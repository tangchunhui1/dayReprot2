package com.yunwei.dayReprot.view;
/*    */
/*    */ import com.yunwei.dayReprot.dao.UsersService;
/*    */ import java.io.IOException;
/*    */ import java.io.PrintWriter;
/*    */ import javax.servlet.http.HttpServletRequest;
/*    */ import javax.servlet.http.HttpServletResponse;
/*    */ import org.springframework.beans.factory.annotation.Autowired;
/*    */ import org.springframework.stereotype.Controller;
/*    */ import org.springframework.web.bind.annotation.GetMapping;
/*    */ import org.springframework.web.bind.annotation.PostMapping;
/*    */ import org.springframework.web.bind.annotation.ResponseBody;
/*    */

/*    */ @Controller
/*    */ @ResponseBody
/*    */ public class LoginViewController
/*    */ {
/*    */   @Autowired
/*    */   UsersService usersService;
/*    */
/*    */   @PostMapping({"login"})
/*    */   @ResponseBody
/*    */   public void login(HttpServletRequest request, HttpServletResponse response) throws IOException {
/* 41 */     response.setContentType("text/html;charset=utf-8");
/* 42 */     PrintWriter writer = response.getWriter();
/* 43 */     String msg = null;
/* 44 */     String username = request.getParameter("userName");
/* 45 */     String password = request.getParameter("passWord");
/*    */
/* 47 */     System.out.print("这是前端填入的用户名和密码" + username + password);
/*    */
/*    */
/* 50 */     String rightUserName = this.usersService.getUserName(username);
/* 51 */     String rightPassword = this.usersService.getPassWord(username);
/*    */
/* 53 */     System.out.print("这是通过输入的用户名从数据库查到的用户名和密码" + rightUserName + rightPassword);
/*    */
/* 55 */     if (null == username || null == password) {
/* 56 */       msg = "alert( '用户名和密码不能为null!' );history.go(-1)";
/* 57 */       writer.print("<script type='text/javascript'>" + msg + "</script>");
/* 58 */       writer.flush();
/* 59 */       writer.close();
/*    */     }
/*    */
/*    */
/* 63 */     if (!username.equals(rightUserName) || !password.equals(rightPassword)) {
/* 64 */       msg = "alert( '用户名或密码错误请重新输入!' );history.go(-1)";
/* 65 */       writer.print("<script type='text/javascript'>" + msg + "</script>");
/* 66 */       writer.flush();
/* 67 */       writer.close();
/* 68 */       System.out.print("用户名或密码错误请重新输入");
/*    */     }
/*    */     else {
/*    */
/* 72 */       request.getSession().setAttribute("loginName", username);
/* 73 */       msg = "alert( '登录成功！' );location.href='yunwei'";
/* 74 */       writer.print("<script type='text/javascript'>" + msg + "</script>");
/* 75 */       writer.flush();
/* 76 */       writer.close();
/*    */     }
/*    */   }
/*    */
/*    */
/*    */
/*    */
/*    */
/*    */
/*    */
/*    */   @GetMapping({"/loginout"})
/*    */   @ResponseBody
/*    */   public String loginOut(HttpServletRequest request) {
/* 89 */     request.getSession().invalidate();
/* 90 */     return "redirect:/";
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\yuebao-0.0.1-SNAPSHOT.war!\WEB-INF\classes\com\yunwei\dayReport\view\LoginViewController.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */
