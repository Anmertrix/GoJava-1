/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: jetty/9.3.5.v20151012
 * Generated at: 2015-12-04 14:28:56 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = null;
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

final java.lang.String _jspx_method = request.getMethod();
if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method) && !javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPs only permit GET POST or HEAD");
return;
}

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\n");
      out.write("<html>\n");
      out.write("  <head>\n");
      out.write("    <link href=\"http://s3.amazonaws.com/codecademy-content/courses/ltp/css/shift.css\" rel=\"stylesheet\">\n");
      out.write("    <link rel=\"stylesheet\" href=\"http://s3.amazonaws.com/codecademy-content/courses/ltp/css/bootstrap.css\">\n");
      out.write("    <link rel=\"stylesheet\" href=\"/css/indexStyle.css\">\n");
      out.write("    <title>AirBnB</title>\n");
      out.write("  </head>\n");
      out.write("  <body>\n");
      out.write("\n");
      out.write("    <div class=\"jumbotron\">\n");
      out.write("    <div class=\"nav\">\n");
      out.write("          <div class=\"containerNav\">\n");
      out.write("            <ul class=\"pull-left\">\n");
      out.write("              <li><a href=\"#\">Name</a></li>\n");
      out.write("              <li><a href=\"#\">Browse</a></li>\n");
      out.write("            </ul>\n");
      out.write("            <ul class = \"pull-right\">\n");
      out.write("              <li id=\"signup\"><a href=\"/registration\">Sign Up</a></li>\n");
      out.write("              <li id=\"login\"><a href=\"/login\">Log In</a></li>\n");
      out.write("              <li id=\"help\"><a href=\"#\">Help</a></li>\n");
      out.write("            </ul>\n");
      out.write("          </div>\n");
      out.write("        </div>\n");
      out.write("      <div class=\"container\">\n");
      out.write("        <div class=\"image\">\n");
      out.write("\n");
      out.write("        </div>\n");
      out.write("        <form action=\"/\" method=\"get\">\n");
      out.write("            <h1>WELCOME HOME");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${name}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("</h1>\n");
      out.write("            <p>Rent from people in over 34,000 cities and 192 countries.</p>\n");
      out.write("        </form>\n");
      out.write("      </div>\n");
      out.write("    </div>\n");
      out.write("    <div class=\"neighborhood-guides\">\n");
      out.write("        <div class=\"container\">\n");
      out.write("            <h2>Neighborhood Guides</h2>\n");
      out.write("            <p>Not sure where to stay? We've created neighborhood cuides for cities all around the world</p>\n");
      out.write("            <div class=\"row\">\n");
      out.write("                <div class=\"col-md-4\">\n");
      out.write("                <div class=\"thumbnail\">\n");
      out.write("                    <a href=\"\"><img src=\"http://goo.gl/0sX3jq\"></a>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"thumbnail\">\n");
      out.write("                    <img src=\"http://goo.gl/an2HXY\">\n");
      out.write("                </div>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"col-md-4\">\n");
      out.write("                <div class=\"thumbnail\">\n");
      out.write("                    <img src=\"http://goo.gl/Av1pac\">\n");
      out.write("                </div>\n");
      out.write("                <div class=\"thumbnail\">\n");
      out.write("                    <img src=\"http://goo.gl/vw43v1\">\n");
      out.write("                </div>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"col-md-4\">\n");
      out.write("                    <div class=\"thumbnail\">\n");
      out.write("                        <img src=\"http://goo.gl/0Kd7UO\">\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("    </div>\n");
      out.write("    <div class=\"learn-more\">\n");
      out.write("\t  <div class=\"container\">\n");
      out.write("\t\t<div class=\"row\">\n");
      out.write("\t      <div class=\"col-md-4\">\n");
      out.write("\t\t\t<h3>Travel</h3>\n");
      out.write("\t\t\t<p>From apartments and rooms to treehouses and boats: stay in unique spaces in 192 countries.</p>\n");
      out.write("\t\t\t<p><a href=\"#\">See how to travel on Airbnb</a></p>\n");
      out.write("\t      </div>\n");
      out.write("\t\t  <div class=\"col-md-4\">\n");
      out.write("\t\t\t<h3>Host</h3>\n");
      out.write("\t\t\t<p>Renting out your unused space could pay your bills or fund your next vacation.</p>\n");
      out.write("\t\t\t<p><a href=\"#\">Learn more about hosting</a></p>\n");
      out.write("\t\t  </div>\n");
      out.write("\t\t  <div class=\"col-md-4\">\n");
      out.write("\t\t\t<h3>Trust and Safety</h3>\n");
      out.write("\t\t\t<p>From Verified ID to our worldwide customer support team, we've got your back.</p>\n");
      out.write("\t\t\t<p><a href=\"#\">Learn about trust at Airbnb</a></p>\n");
      out.write("\t\t  </div>\n");
      out.write("\t    </div>\n");
      out.write("\t  </div>\n");
      out.write("\t</div>\n");
      out.write("  </body>\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
