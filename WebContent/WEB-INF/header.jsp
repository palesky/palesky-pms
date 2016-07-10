<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
	<div class="container-fluid">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#sidebar-collapse">
				<span class="sr-only">Toggle navigation</span>
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="index.jsp"><span>Palesky</span>软件测试管理平台</a>
			<ul class="user-menu">
				<li class="dropdown pull-right">
					<a href="#" class="dropdown-toggle" data-toggle="dropdown"><svg class="glyph stroked male-user"><use xlink:href="#stroked-male-user"></use></svg> ${user.name} <span class="caret"></span></a>
					<ul class="dropdown-menu" role="menu">
						<li><a href="profile"><svg class="glyph stroked male-user"><use xlink:href="#stroked-male-user"></use></svg> 个人信息</a></li>
						<li><a href="setting"><svg class="glyph stroked gear"><use xlink:href="#stroked-gear"></use></svg> 设置</a></li>
						<li><a href="logout"><svg class="glyph stroked cancel"><use xlink:href="#stroked-cancel"></use></svg> 注销</a></li>
					</ul>
				</li>
			</ul>
		</div>
						
	</div><!-- /.container-fluid -->
</nav>