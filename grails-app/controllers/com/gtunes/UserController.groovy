package com.gtunes

class UserController {

    def index() { }
	
	
	
	def register() { 
		if(request.method== 'POST')
		{
			def u = new User(params)
		    if (u.password != params.confirm)
			{
				u.errors.rejectValue("password", "user.password.dontmatch")
				return [user:u]
			}
			else if (u.save())
			{
				session.user = u
				redirect controller:"store"
			}
			else
				return [user:u]
		}
	}
}
