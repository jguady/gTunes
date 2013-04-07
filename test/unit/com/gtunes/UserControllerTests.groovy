package com.gtunes



import grails.test.mixin.*
import org.junit.*

/**
 * See the API for {@link grails.test.mixin.web.ControllerUnitTestMixin} for usage instructions
 */
@TestFor(UserController)
@Mock(User)
class UserControllerTests {

    void testPasswordsDoNotMatch() {
       request.method = 'POST'
	   
	   params.login = 'guady'
	   params.password = 'invalid'
	   params.confirm = 'dilavni'
	   params.firstName = 'Jay'
	   params.lastName='G'
	   
	   def model = controller.register()
	   def user= model.user
	   
	   assert user.hasErrors()
	   assert 'user.password.dontmatch'==user.errors['password'].code
	   
    }
	void testRegistrationFailed()
	{
		request.method = 'POST'
	   
	   params.login = ''
	   
	   
	   def model = controller.register()
	   def user= model.user
	   
	   assert user.hasErrors()
	   assert session.user == null
	   assert 'blank' == user.errors['login']
	   assert 'nullable' == user.errors['firstName']
	   assert 'nullable' == user.errors['lastName']
	   assert 'user.password.dontmatch'==user.errors['password'].code
	}
	
	void testRegistrationSuccess()
	{
		request.method = 'POST'
		params.login = 'guady'
		params.password = 'password'
		params.confirm = 'password'
		params.firstName = 'Jay'
		params.lastName='Guady'
		
		
		controller.register()
		
		assert '/store' == response.redirectedUrl
		assert session.user !=null
		
		
		
	}
	void testLoginUserNotFound()
	{
		request.method = 'POST'
		params.login = 'steve'
		params.password = 'thatguy'
		
		
		
		controller.login()
		def cmd = model.loginCmd
		assert cmd.hasErrors()
		assert 'user.not.found' == cmd.errors['login'].code
		assert session.user == null
		assert '/store/index' == view
		
	}
	void testLoginFailurePasswordInvalid()
	{
		request.method = 'POST'
		
		def u = new User(login:'scott',password:'murdertown', firstName:'Scott', lastName:'Clutter').save()
		assert u != null
		
		params.login = 'scott'
		params.password = 'nainhiru'
		controller.login()
		
		def cmd = model.loginCmd
		assert cmd.hasErrors()
		assert 'user.password.invalid' == cmd.errors['password'].code
		assert '/store/index' == view
		
		
	}
	void testLoginSuccess()
	{
		request.method = 'POST'
		
		def u = new User(login:'scott',password:'murdertown', firstName:'Scott', lastName:'Clutter').save()
		assert u != null
		
		params.login = 'scott'
		params.password = 'murdertown'
		
		controller.login()
		
		
		
		assert session.user !=null
		assert response.redirectedUrl == "/store"
	}
}
