package com.example.lab3ee;

import Exceptions.WrongParameterExceptions;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@WebServlet(name = "AdvancedCalc", value = "/AdvancedCalc")
public class AdvancedCalcServlet extends HttpServlet {

    private ConfigReader configReader;


    @Override
    public void init() throws ServletException {
        try {
            configReader = new ConfigReader();
        } catch (IOException e) {
            e.printStackTrace();
            throw new ServletException("Something gone wrong");
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

        try {
            Map<String, String[]> map = request.getParameterMap();
            Params params = new Params(map);
            Validator.validate(params);

            double[] arrayOfParams = params.toArray();
            int rowsAmount = getRowsAmount(arrayOfParams);

            String[][] table = new String[rowsAmount][5];
            rowsAmount = 0;
            for (double i = arrayOfParams[0]; i <= arrayOfParams[4]; i += arrayOfParams[8]) {
                for (double j = arrayOfParams[1]; j <= arrayOfParams[5]; j += arrayOfParams[9]) {
                    for (double k = arrayOfParams[2]; k <= arrayOfParams[6]; k += arrayOfParams[10]) {
                        for (double l = arrayOfParams[3]; l <= arrayOfParams[7]; l += arrayOfParams[11], rowsAmount++) {
                            table[rowsAmount][0] = String.valueOf(i);
                            table[rowsAmount][1] = String.valueOf(j);
                            table[rowsAmount][2] = String.valueOf(k);
                            table[rowsAmount][3] = String.valueOf(l);
                            try {
                                table[rowsAmount][4] = String.valueOf(Formulas.solve(i, j, k, l));
                            } catch (WrongParameterExceptions e) {
                                table[rowsAmount][4] = e.getMessage();
                            }
                        }
                    }
                }
            }

            addCookie(params.getParams(), response);
            getServletContext().setAttribute("table", table);
            response.sendRedirect("/index.jsp");


        } catch (ArithmeticException | IllegalArgumentException e) {
            e.printStackTrace();
            response.sendError(412, e.getMessage());
        }
    }

    protected void addCookie(Map<String, String> params, HttpServletResponse response) {
        List<String> keysList = Keys.getNames();
        Cookie[] cookie = new Cookie[keysList.size()];

        for (int i = 0; i < keysList.size(); i++) {
            String keyName = keysList.get(i);
            cookie[i] = new Cookie(keyName, params.get(keyName));
            cookie[i].setMaxAge(Integer.parseInt(configReader.getProperty("age")));
            response.addCookie(cookie[i]);

        }
    }

    private int getAmountOfValues(double[] array, int parameterToIndex) {
        int parameterFromIndex = -4;
        int parameterStepIndex = 4;
        return (int) ((array[parameterToIndex] - array[parameterToIndex + parameterFromIndex]) / array[parameterToIndex + parameterStepIndex] + 1);
    }

    private int getRowsAmount(double[] arrayOfParams) {
        int aToIndex = Keys.getNames().indexOf("aTo");
        int bToIndex = Keys.getNames().indexOf("bTo");
        int cToIndex = Keys.getNames().indexOf("cTo");
        int dToIndex = Keys.getNames().indexOf("dTo");
        return getAmountOfValues(arrayOfParams, aToIndex) * getAmountOfValues(arrayOfParams, bToIndex) *
                getAmountOfValues(arrayOfParams, cToIndex) * getAmountOfValues(arrayOfParams, dToIndex);
    }
}
