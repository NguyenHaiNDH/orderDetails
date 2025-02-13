package controller;

import dao.ProductDAO;
import model.Product;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@WebServlet("/products") // Sửa đúng đường dẫn
public class ProductServlet extends HttpServlet {
    private static final Logger LOGGER = Logger.getLogger(ProductServlet.class.getName());
    private final ProductDAO productDAO = new ProductDAO();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");

        try {
            if (action == null || action.equals("list")) {
                List<Product> products = productDAO.getAllProducts();
                req.setAttribute("products", products);
                req.getRequestDispatcher("products.jsp").forward(req, resp);
            } else if (action.equals("edit")) { // Xử lý edit
                int id = Integer.parseInt(req.getParameter("id"));
                Product product = productDAO.getProductById(id);
                if (product == null) {
                    resp.sendRedirect("products");
                    return;
                }
                req.setAttribute("product", product);
                req.getRequestDispatcher("edit_product.jsp").forward(req, resp);
            } else if (action.equals("delete")) {
                int id = Integer.parseInt(req.getParameter("id"));
                productDAO.deleteProduct(id);
                resp.sendRedirect("products");
            } else {
                resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid action");
            }
        } catch (NumberFormatException e) {
            LOGGER.log(Level.SEVERE, "Invalid product ID format", e);
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid product ID format");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");

        try {
            if ("add".equals(action)) {
                Product product = new Product(0, req.getParameter("name"),
                        Double.parseDouble(req.getParameter("price")),
                        Integer.parseInt(req.getParameter("quantity")));
                productDAO.addProduct(product);
            } else if ("update".equals(action)) {
                Product product = new Product(Integer.parseInt(req.getParameter("id")),
                        req.getParameter("name"),
                        Double.parseDouble(req.getParameter("price")),
                        Integer.parseInt(req.getParameter("quantity")));
                productDAO.updateProduct(product);
            } else {
                resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid action");
                return;
            }
            resp.sendRedirect("products"); // Sửa redirect
        } catch (NumberFormatException e) {
            LOGGER.log(Level.SEVERE, "Invalid number format in request", e);
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid number format");
        }
    }
}
