package lv.javaguru.java2.servlet.mvc;

import lv.javaguru.java2.database.CarDAO;
import lv.javaguru.java2.database.DBException;
import lv.javaguru.java2.database.jdbc.CarDAOImpl;
import lv.javaguru.java2.database.jdbc.UserDAOImpl;
import lv.javaguru.java2.domain.Car;
import lv.javaguru.java2.domain.User;

import javax.servlet.http.HttpServletRequest;

public class CarController implements MVCController {

    @Override
    public MVCModel processRequest(HttpServletRequest req) {
        String make = req.getParameter("make");
//        String password = req.getParameter("password");

        // check with database
        CarDAO carDAO = new CarDAOImpl();
        try {
            Car car = carDAO.getByMake(make);

 /*           car = new Car();
            car.setMake("Ford");
            car.setModel("Escort");
            car.setProductionYear(1990);    */

            if (car.getMake().equals("Mazda")) {
                // ok
                return new MVCModel(car, "/carFound.jsp");
            } else {
                // no
                return new MVCModel(null, "/carNotFound.jsp");
            }
        } catch (DBException e) {
            return new MVCModel(null, "/carNotFound.jsp");
        }

    }

}