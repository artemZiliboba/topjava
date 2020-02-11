package ru.javawebinar.topjava.web;

import org.slf4j.Logger;
import ru.javawebinar.topjava.model.Meal;
import ru.javawebinar.topjava.model.MealTo;
import ru.javawebinar.topjava.util.MealsUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.util.Arrays;
import java.util.List;

import static ru.javawebinar.topjava.util.TimeUtil.isBetweenInclusive;
import static ru.javawebinar.topjava.util.MealsUtil.filteredByStreams;

import static org.slf4j.LoggerFactory.getLogger;

public class MealServlet extends HttpServlet {
    private static final Logger log = getLogger(UserServlet.class);

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        log.debug("redirect to meals");

        List<MealTo> meals = Arrays.asList(
                new MealTo(LocalDateTime.of(2020, Month.JANUARY, 30, 10, 0), "Завтрак", 500, false),
                new MealTo(LocalDateTime.of(2020, Month.JANUARY, 30, 13, 0), "Обед", 1000, false),
                new MealTo(LocalDateTime.of(2020, Month.JANUARY, 30, 20, 0), "Курица", 500, false),
                new MealTo(LocalDateTime.of(2020, Month.JANUARY, 31, 0, 0), "Окрошка", 100, false),
                new MealTo(LocalDateTime.of(2020, Month.JANUARY, 31, 10, 0), "Шашлык", 5000, true),
                new MealTo(LocalDateTime.of(2020, Month.JANUARY, 31, 13, 0), "Жрач перед сном", 500, false),
                new MealTo(LocalDateTime.of(2020, Month.JANUARY, 31, 20, 0), "Ужин", 410, false)
        );

        request.setAttribute("list", meals);
        //request.setAttribute("test", "My test text");

        request.getRequestDispatcher("meals.jsp").forward(request, response);
        //response.sendRedirect("meals.jsp");
    }
}
