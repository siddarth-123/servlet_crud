package Controller;

import java.io.IOException;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.Userdao;
import DTO.userinfo;

@WebServlet("/login")
public class login extends HttpServlet {
	
@Override
protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
// TODO Auto-generated method stub
String emph = req.getParameter("emph");
String password = req.getParameter("pwd");

Userdao dao=new Userdao();
try
{
long mobile = Long.parseLong(emph);
userinfo info=dao.fetch(mobile);
if(info==null){
res.getWriter().print("<h1>Invalid Mobile Number</h1>");
}
else
{
if(info.getPassword().equals(password))
{
res.getWriter().print("<h1>Login successfull</h1>");
res.sendRedirect("https://www.facebook.com");
}
else{
res.getWriter().print("<h1>Invalid password</h1>");
}
}
}
catch (NumberFormatException e)
{
String email = emph;
userinfo info=dao.fetch(email);
if(info==null){
res.getWriter().print("<h1>Invalid email</h1>");
}
else
{
if(info.getPassword().equals(password))
{
res.getWriter().print("<h1>Login successfull</h1>");
res.sendRedirect("https://www.facebook.com");

}
else{
res.getWriter().print("<h1>Invalid password</h1>");
}
}
}
}
}