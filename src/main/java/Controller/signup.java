package Controller;

import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;
import java.time.Period;
import java.util.Arrays;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

import DAO.Userdao;
import DTO.userinfo;

@WebServlet("/signup")
public class signup extends GenericServlet {

@Override
public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {

Date date = Date.valueOf(req.getParameter("dob"));

userinfo info = new userinfo();
info.setAddress(req.getParameter("address"));
info.setCountry(req.getParameter("country"));
info.setDate(Date.valueOf(req.getParameter("dob")));
info.setEmail(req.getParameter("email"));
info.setGender(req.getParameter("gender"));
info.setMobile(Long.parseLong(req.getParameter("mobile")));
info.setName(req.getParameter("name"));
info.setPassword(req.getParameter("password"));
info.setSkills(req.getParameterValues("quali[]"));

//info.setAge(Period.between(date.toLocalDate(), LocalDate.now()).getYears());
// int yob = date.toLocalDate().getYear();
// int ty = LocalDate.now().getYear();

Userdao dao = new Userdao();
dao.save(info);

res.getWriter().print("<h1>Account created successfully</h1>");

// res.getWriter().print("<h1>"
// + "Name: "+name+"<br>"
// + "mobile: "+mobile+"<br>"
// + "email: "+email+"<br>"
// + "Password: "+Password+"<br>"
// + "Date: "+date+"<br>"
// + "gender: "+gender+"<br>"
// + "Address: "+Address+"<br>"
// + "Country: "+country+"<br>"
// + "Skills: "+Arrays.toString(Skills)+"<br>"
// + "</h1>");

}

}