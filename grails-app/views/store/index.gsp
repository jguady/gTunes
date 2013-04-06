<html>
<head>
<meta http-equiv="Content-type" content="text/html; charset=utf-8">
<meta name="layout" content="main">
<title>gTunes Store</title>
</head>
<body id="body">
	<div class="container-fluid">
		<div id="navPane" class="row-fluid">
			<div class="span2"></div>
		</div>



		<!-- Body Content -->
		<div class="span10">
			<div id="RegisterPane" class="span3">
				<g:if test="${session.user}">
					<ul>
						<li><g:link controller="user" action="music">My Music</g:link></li>
						<li><g:link controller="store" action="shop">The Store</g:link></li>
					</ul>
				</g:if>
				<g:else>
					<div id="registerPane">
						<h3>Need an Account?</h3>
						<br>
						<g:link controller="user" action="register">Signup Now</g:link>
						to start your own personal Music Collection!

					</div>
					<div>
						<g:link controller="user" action="register">

							<input class="btn btn-primary" id="registerButton"
								value="Signup Now">
						</g:link>
					</div>
				</g:else>

			</div>
			<div id="loginBox" class="span4 offset2">
				<g:if test="${session?.user}">
					<div style="margin-top: 20px">
						<div style="float: right;">
							<a href="#">Profile</a>|
							<g:link controller="user" action="logout">Logout</g:link>
							<br>
						</div>
						Welcome Back <span id="userFirstName"> ${session?.user?.firstName}!
						</span><br> <br> You have purchased (${session.user.purchasedSongs?.size() ?:0 })
						songs. <br>
					</div>
				</g:if>
				<g:else>
					<g:form name="loginForm" url="[controller:'user',action:'login']">
						<div>
							<h3>Already a Member?</h3>
						</div>
						<div>
							<p>Sign in to your gTunes account
						</div>
						<div>Username:</div>
						<g:textField class="span2" name="login"
							value="${fieldValue(bean:loginCmd,field:'login') }">
						</g:textField>
						<div>Password:</div>
						<g:passwordField name="password">
						</g:passwordField>
						<br />

						<input type="button" value="Login" name="loginButton"
							id="loginButton" class="btn btn-primary"-->

					</g:form>
					<g:renderErrors bean="${loginCmd}"></g:renderErrors>
				</g:else>
			</div>
		</div>
	</div>
</body>
</html>