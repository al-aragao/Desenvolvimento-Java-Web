<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="tl"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html lang="en">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>TP3 - Thiago Aragão</title>
        <link
            href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
            rel="stylesheet"
            integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
            crossorigin="anonymous">
        <link href="/styles/style.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <div class="container">
            <div class="row content">
                <div class="col-md-6 mb-3">
                    <img src="/images/landing_page.png" class="img-fluid" />
                </div>
                <div class="col-md-6">
                    <h3 class="sigin-text mb-3">Ventura Hr Jobs</h3>
                    <form class="mb-3" action="/User/SignIn" method="POST">
                        <div class="form-group mb-3">
                            <label for="email">Email</label>
                            <input class="form-control" type="email" name='email' value="tbaragao@gmail.com" size="100" maxlength="100"/>
                        </div>
                        <div class="form-group mb-3">
                            <label for="password">Password</label>
                            <input  class="form-control" type="password" value="123456" name="password" />
                        </div>
                        
                        <tl:if test="${not empty errorMessage }">
							<div class="mb-3">
								<small class="text-danger">${ errorMessage }</small>
							</div>
						</tl:if>
						
                        <button class="btn btn-class" type="submit" name="submit">Sign In</button>
                    </form>
                    <p>Don't have account it? Select one option to sign-up:</p>
                    <a class="btn btn-class" href="/User/SignUp">Create new account</a>
<!--                     <a class="btn btn-class" href="/Candidate/SignUp">Candidate</a>  -->
<!--                     <a class="btn btn-class" href="/Company/SignUp">Company</a> -->
                </div>
            </div>
        </div>

        <script
            src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
        crossorigin="anonymous"></script>
    </body>
</html>