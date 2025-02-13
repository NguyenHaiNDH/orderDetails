package controller;

import dao.OrderDetailsDAO;
import model.OrderDetails;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/orderDetails")
public class OrderDetailsServlet extends HttpServlet {
    private final OrderDetailsDAO orderDetailsDAO = new OrderDetailsDAO();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<OrderDetails> orderDetailsList = orderDetailsDAO.getOrderDetailsWithCustomerAndProduct();
        req.setAttribute("orderDetailsList", orderDetailsList);
        req.getRequestDispatcher("orderDetails.jsp").forward(req, resp);
    }
}
