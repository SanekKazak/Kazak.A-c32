package org.alex.web;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
/*
создать проект, поделючить библиотеку servlet-api
и подключить плагин war

создать сервлет, прописать его маппинг
и в самом сервлете вывести в ответ - текущую дату и время

проверить что браузер может открыть страницу
+ так же проверить работу через postman
 */
public class DateServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        PrintWriter writer = resp.getWriter();
        writer.println("time now " + LocalDateTime.now());
    }
}
