<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	<%@include file="/common/taglib.jsp"%>
		<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
		<html>
		<head>
			<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
			<title>
				<spring:message code="Label.Home" text="Home" />
			</title>
		</head>
		<body>
				<div class="main">
						<div class="content">
							<div class="section group">
									<div class="col span_2_of_3">
									  <div class="contact-form">
										  <h2>Contact Us</h2>
											<form method="post" action="contact-post.html">
												<div>
													<span><label>Name</label></span>
													<span><input name="userName" type="text" class="textbox" ></span>
												</div>
												<div>
													<span><label>E-mail</label></span>
													<span><input name="userEmail" type="text" class="textbox"></span>
												</div>
												<div>
													 <span><label>Company Name</label></span>
													<span><input name="userPhone" type="text" class="textbox"></span>
												</div>
												<div>
													<span><label>Subject</label></span>
													<span><textarea name="userMsg"> </textarea></span>
												</div>
											   <div>
													   <span><input type="submit" value="Submit"  class="myButton"></span>
											  </div>
											</form>
									  </div>
									  </div>
									<div class="col span_1_of_3">
										<div class="contact_info">
											 <h3>Find Us Here</h3>
												  <div class="map">
														<iframe width="100%" height="175" frameborder="0" scrolling="no" marginheight="0" marginwidth="0" 
														src="https://www.google.com/maps/embed?pb=!1m14!1m8!1m3!1d3856.9719000592913!2d139.7277084933118!3d35.61998871935972!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x60188af43329b6f1%3A0x6f93df60902913bc!2zU1VT5p2x5Lqs5pSv5bqX!5e0!3m2!1svi!2sjp!4v1528088827625"></iframe><br><small>
														<a href="https://maps.google.co.in/maps?f=q&amp;source=embed&amp;hl=en&amp;geocode=&amp;q=Lighthouse+Point,+FL,+United+States&amp;aq=4&amp;oq=light&amp;sll=26.275636,-80.087265&amp;sspn=0.04941,0.104628&amp;ie=UTF8&amp;hq=&amp;hnear=Lighthouse+Point,+Broward,+Florida,+United+States&amp;t=m&amp;z=14&amp;ll=26.275636,-80.087265" 
														style="color:#666;text-align:left;font-size:12px">View Larger Map</a></small>
													</div>
										  </div>
									  <div class="company_address">
											 <h3>Company Information :</h3>
												<p>〒141-0032</p>
												<p>東京都品川区大崎一丁目6番4号　新大崎勧業ビルディング7階</p>
												<p>Japan</p>
											   <p>Phone:03-6431-9332</p>
											   <p>Fax: 03-6431-9388</p>
												<p>Email: <span>info@mycompany.com</span></p>
											   <p>Follow on: <span>Facebook</span>, <span>Twitter</span></p>
									   </div>
									 </div>
								  </div>		
							 </div> 
						</div>
					 </div>
		</body>

		</html>