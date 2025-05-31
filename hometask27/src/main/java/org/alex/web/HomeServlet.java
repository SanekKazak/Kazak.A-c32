package org.alex.web;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet(value = "/home")
public class HomeServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Car> cars = List.of(
                new Car(1,  "Toyota Camry",            25_000),
                new Car(2,  "Honda Accord",            24_000),
                new Car(3,  "BMW 3 Series",            40_000),
                new Car(4,  "Audi A4",                 42_000),
                new Car(5,  "Kia Rio",                 18_000),
                new Car(6,  "Mercedes-Benz C-Class",   45_000),
                new Car(7,  "Volkswagen Passat",       23_000),
                new Car(8,  "Hyundai Elantra",         21_000),
                new Car(9,  "Mazda 6",                 22_000),
                new Car(10, "Ford Focus",              20_000)
        );
        req.setAttribute("cars", cars);
        req.getRequestDispatcher("/WEB-INF/home.jsp").forward(req, resp);
    }

}
