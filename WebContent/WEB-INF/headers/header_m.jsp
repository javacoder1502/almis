<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- Navigation -->
<nav class="navbar navbar-default navbar-static-top" role="navigation"
	style="margin-bottom: 0; background-color: #E34043; color: #fff;">
	<div class="navbar-header">
		<button type="button" class="navbar-toggle" data-toggle="collapse"
			data-target=".navbar-collapse">
			<span class="sr-only">Toggle navigation</span> <span class="icon-bar"></span>
			<span class="icon-bar"></span> <span class="icon-bar"></span>
		</button>
		<a class="navbar-brand" href="#" style="color: #fff;">Airtel-Mis</a>
	</div>
	<!-- /.navbar-top-links -->

	<div class="navbar-default sidebar" role="navigation">
		<section class="logo">
			<img src="<c:url value="/resources/img/airel-TeCake-.png" />" />
		</section>
		<div class="sidebar-nav navbar-collapse">

			<ul class="nav" id="side-menu">
				<li><a href="#"> <i class="fa fa-sitemap fa-fw"></i>Content
						Response<span class="fa arrow"></span>
				</a>
					<ul class="nav nav-second-level">
						<li style="border-top: 1px solid #efefef;"><a
							href="/ContentMIS/contentResponse/video"> Video <!-- <span class="fa arrow"></span> -->
						</a> <!-- <ul class="nav nav-third-level">
									<li style="background:#337ab7;color:#fff;border-top:1px solid #efefef;">
									<a href="" style="color:#fff;">DateWise</a></li>
									<li style="background:#337ab7;color:#fff;border-top:1px solid #efefef;"><a href="#" style="color:#fff;">HourWise</a></li>

								</ul>  --> <!-- /.nav-third-level --></li>
						<li><a href="/ContentMIS/contentResponse/Wallpaper">Wallpaper</a></li>
						<li><a href="/ContentMIS/contentResponse/Animation">Animation</a></li>
						<li><a href="/ContentMIS/contentResponse/Game">Game</a></li>
						<li><a href="/ContentMIS/contentResponse/Ringtone">Ringtone</a></li>

					</ul> <!-- /.nav-second-level --></li>

				<li><a href="#"><i class="fa fa-bar-chart-o fa-fw"></i>
						Uploaded Content<span class="fa arrow"></span></a>
					<ul class="nav nav-second-level">
						<li><a href="/ContentMIS/contentUploadDetails/Video">Video<span
								class="fa arrow"></span></a>
							<ul class="nav nav-third-level">

								<li
									style="background: #337ab7; color: #fff; border-top: 1px solid #efefef;">
									<a href="/ContentMIS/contentUploadDetails/Video"
									style="color: #fff;">DateWise</a>
								</li>
								<li
									style="background: #337ab7; color: #fff; border-top: 1px solid #efefef;">
									<a href="/ContentMIS/contentUploadDetails/Video/total"
									style="color: #fff;">Total</a>
								</li>

							</ul></li>
						<li><a href="/ContentMIS/contentUploadDetails/Wallpaper">Wallpaper<span
								class="fa arrow"></span></a>

							<ul class="nav nav-third-level">
								<li
									style="background: #337ab7; color: #fff; border-top: 1px solid #efefef;">
									<a href="/ContentMIS/contentUploadDetails/Wallpaper"
									style="color: #fff;">DateWise</a>
								</li>
								<li
									style="background: #337ab7; color: #fff; border-top: 1px solid #efefef;">
									<a href="/ContentMIS/contentUploadDetails/Wallpaper/total"
									style="color: #fff;">Total</a>
								</li>

							</ul></li>
						<li><a href="/ContentMIS/contentUploadDetails/Animation">Animation<span
								class="fa arrow"></span></a>
							<ul class="nav nav-third-level">
								<li
									style="background: #337ab7; color: #fff; border-top: 1px solid #efefef;">
									<a href="/ContentMIS/contentUploadDetails/Animation"
									style="color: #fff;">DateWise</a>
								</li>
								<li
									style="background: #337ab7; color: #fff; border-top: 1px solid #efefef;">
									<a href="/ContentMIS/contentUploadDetails/Animation/total"
									style="color: #fff;">Total</a>
								</li>

							</ul></li>
						<li><a href="/ContentMIS/contentUploadDetails/Game">Game<span
								class="fa arrow"></span></a>
							<ul class="nav nav-third-level">
								<li
									style="background: #337ab7; color: #fff; border-top: 1px solid #efefef;">
									<a href="/ContentMIS/contentUploadDetails/Game"
									style="color: #fff;">DateWise</a>
								</li>
								<li
									style="background: #337ab7; color: #fff; border-top: 1px solid #efefef;">
									<a href="/ContentMIS/contentUploadDetails/Game/total"
									style="color: #fff;">Total</a>
								</li>

							</ul></li>
						<li><a href="/ContentMIS/contentUploadDetails/Ringtone">Ringtone<span
								class="fa arrow"></span></a>
							<ul class="nav nav-third-level">
								<li
									style="background: #337ab7; color: #fff; border-top: 1px solid #efefef;">
									<a href="/ContentMIS/contentUploadDetails/Ringtone"
									style="color: #fff;">DateWise</a>
								</li>
								<li
									style="background: #337ab7; color: #fff; border-top: 1px solid #efefef;">
									<a href="/ContentMIS/contentUploadDetails/Ringtone/total"
									style="color: #fff;">Total</a>
								</li>

							</ul></li>

					</ul> <!-- /.nav-second-level --></li>





			</ul>
		</div>
		<!-- /.sidebar-collapse -->
	</div>
	<!-- /.navbar-static-side -->
</nav>