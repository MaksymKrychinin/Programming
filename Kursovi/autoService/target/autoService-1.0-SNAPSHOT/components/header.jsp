<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<header>
    <script src="../js/slide.js"></script>
    <script src="../js/formOpenClose.js"></script>
    <script src="../js/RegistrationForm.js"></script>
    <link rel="stylesheet" href="../css/stylesheet.css">
    <h4 style="cursor:pointer"><a onclick="openSlideBar()">Menu</a></h4>
    <img class="logo_small" src="../img/logo.jpg" alt="logo">
    <c:if test="${user==null}">
        <h4 style="cursor:pointer"><a onclick="showForm('signIn')">Sign in</a>
        </h4>
        <h4 style="cursor:pointer"><a onclick="showForm('register')">Register</a>
        </h4>
        <div class="hidden">
            <a class="closeButtonForm" onclick="closeForm('signIn')">X</a>
            <form action="/SignIn" method="post" class="openForm" id="signIn">
                <div class="formElement">
                    <label>Email</label>
                    <input type="text" name="email" required>
                    <small></small>
                </div>
                <div class="formElement">
                    <label>Password</label>
                    <input type="password" name="password" minlength="8" required>
                    <small></small>
                </div>
                <button type="button" onclick="submitLoginForm()">Sign In</button>
            </form>
        </div>
        <div class="hidden">
            <a class="closeButtonForm" onclick="closeForm('register')">X</a>
            <form action="/RegisterServlet" method="post" class="openForm" id="register">
                <div class="formElement">
                    <label>Email</label>
                    <input type="text" name="email" minlength="5" required>
                    <small></small>
                </div>
                <div class="formElement">
                    <label>Password</label>
                    <input type="password" name="password" minlength="8" required>
                    <small></small>
                </div>
                <div class="formElement">
                    <label>Surname</label>
                    <input type="text" name="surname" required>
                    <small></small></div>
                <div class="formElement">
                    <label>Name</label>
                    <input type="text" name="name" required>
                    <small></small>
                </div>
                <div class="formElement">
                    <label>Date</label>
                    <input type="date" name="date" min="1900-01-01" max="2023-01-01" required>
                    <small></small>
                </div>
                <div class="formElement">
                    <label>Your number</label>
                    <input type="tel" id="phone" onkeyup="phoneMask()" name="phoneNumber"
                           pattern="\+[0-9]{2}\([0-9]{3}\)-[0-9]{3}-[0-9]{2}-[0-9]{2}"
                           placeholder="+38(099)-453-22-78" required>
                    <small></small>
                </div>
                <div class="gender"><p>Your Gender:</p>
                    <input type="radio" name="gender" value="Male" required>
                    <label>Male</label>
                    <input type="radio" name="gender" value="Female">
                    <label>Female</label>
                    <input type="radio" name="gender" value="Other">
                    <label>Other</label>
                    <small></small>
                </div>

                <button type="button" onclick="submitRegisterForm()">
                  Register</button>
            </form>
        </div>
    </c:if>
    <c:if test="${user!=null}">
        <a href="/SignOut">Sign Out</a>
    </c:if>
    <c:if test="${user.getRole()=='user'}">
    <a href="/UserBills">My Bills</a>
</c:if>
    <div id="slideBarMenu" class="slideBar">
        <a href="javascript:void(0)" class="closeButton" onclick="closeSlideBar()">X</a>
        <a href="index.jsp">Home</a>
        <c:if test="${user!=null}">
            <a href="/SignOut">SignOut</a>
        </c:if>
        <c:if test="${user.getRole()=='admin'}">
            <a href="index.jsp">AdminPanel</a>
        </c:if>
    </div>
</header>