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
                    <img src="/images/candidate.png" class="img-fluid" />
                </div>
                <div class="col-md-6">
                    <h3 class="sigin-text mb-3">Ventura Hr Jobs</h3>
                    <h4 class="sigin-text mb-3">Candidates register</h4>
                    <form action="/User/SignUp" class="mb-3" method="POST">
                    	<div class="form-group mb-3">
                            <label for="name">Name</label>
                            <input class="form-control" type="text" name='name' maxlength="100" value="Thiago Aragão" required/>
                        </div>
                    	<div class="form-group mb-3">
                            <label for="cpf">CPF</label>
                            <input class="form-control" type="text" name='cpf' value="126.198.647-46" required/>
                        </div>
                    	<div class="form-group mb-3">
                            <label for="phone">Phone</label>
                            <input class="form-control" type="text" name='phone' value="(21) 9-9136-9912" required/>
                        </div>
                    	<div class="form-group mb-3">
                            <label for="birthdate">Birthdate</label>
                            <input class="form-control" type="date" name='birthdate' value="1986-01-27" required/>
                        </div>
                        <div class="form-group mb-3">
                            <label for="email">Email</label>
                            <input class="form-control" type="email" name='email' value="tbaragao@gmail.com" maxlength="100" required/>
                        </div>
                        <div class="form-group mb-3">
                            <label for="addressCode">Cep</label>
                            <input class="form-control" type="number" name='addressCode' value="21921680" maxlength="100" required/>
                        </div>
                        <div class="form-group mb-3">
                            <label for="address">Endereço</label>
                            <input class="form-control" type="text" name='address' value="Rua muiatuca 51, Cobertura 304" maxlength="100" required/>
                        </div>
                        <div class="form-group mb-3">
                            <label for="password">Password</label>
                            <input  class="form-control" type="password" name="password" value="123456" required />
                        </div>
                        <div class="form-group mb-3">
                            <label for="confirmPassword">Confirm password</label>
                            <input  class="form-control" type="password" name="confirmPassword" value="123456" required />
                        </div>
                        <button class="btn btn-class" type="submit" name="submit">Sign up</button>
                    </form>
                    <p>Already have an account? Click <a href="/">here</a> to sign in</p>
                </div>
            </div>
        </div>

        <script
            src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
        crossorigin="anonymous"></script>
    </body>
</html>
