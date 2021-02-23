package com.demo.tags;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspWriter;

import org.springframework.web.servlet.tags.RequestContextAwareTag;

import com.demo.entities.Product;

public class Tag4 extends RequestContextAwareTag {

    private static final long serialVersionUID = 1L;

    @Override
    public void doFinally() {
        JspWriter out = pageContext.getOut();
        try {
            String jspPage = "../tags/tag4.jsp";
            HttpServletRequest request = (HttpServletRequest) pageContext.getRequest();
            List<Product> products = new ArrayList<Product>();
            products.add(new Product("p01", "name 1", 4.5));
            products.add(new Product("p02", "name 2", 2));
            products.add(new Product("p03", "name 3", 3));
            request.setAttribute("products", products);
            request.getRequestDispatcher(jspPage);
            pageContext.include(jspPage);
        } catch (Exception e) {
            try {
                out.print(e.getMessage());
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
    }

    @Override
    protected int doStartTagInternal() throws Exception {
        return 0;
    }

}