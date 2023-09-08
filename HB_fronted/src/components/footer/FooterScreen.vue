<script setup lang="ts"></script>

<template>
	<section id="bottom">
		<div class="container" data-aos="fade-down" data-aos-duration="1500">
			<div class="row">
				<div class="col-md-4 col-sm-6">
					<div class="widget">
						<h3>关于我们</h3>
						<ul>
							<li><a href="#">加入我们</a></li>
							<li><a href="#">联系我们</a></li>
						</ul>
					</div>
				</div>
				<!--/.col-md-3-->

				<div class="col-md-4 col-sm-6">
					<div class="widget">
						<h3>参与互动</h3>
						<ul>
							<li><a href="#">活动</a></li>
						</ul>
					</div>
				</div>
				<!--/.col-md-3-->

				<div class="col-md-4 col-sm-6">
					<div class="widget">
						<h3>联系方式</h3>
						<p>如果您有任何问题或咨询，请随时与我们联系：</p>
						<ul>
							<li><i class="fa fa-envelope"></i> <a href="mailto:info@example.com">liu_hangming@126.com</a></li>
							<li><i class="fa fa-phone"></i> +86 18295501675</li>
							<li><i class="fa fa-map-marker"></i> 宁夏回族自治区 银川市 西夏区</li>
						</ul>
					</div>
				</div>
				<!--/.col-md-3-->
			</div>
		</div>
	</section>
	<!--/#bottom-->
	<footer id="footer" class="midnight-blue">
		<div class="container">
			<div class="row">
				<div class="col-sm-4"><a href="https://beian.miit.gov.cn/">鄂ICP备2023015495号-1</a></div>
				<div class="col-sm-4">&copy; 2023 Johnson Liu. Rights Reserved.</div>
				<div class="col-sm-4">
					<ul class="pull-right">
						<li><router-link :key="'HomePage'" to="/">主页</router-link></li>
						<li><router-link :key="'AboutUs'" to="/AboutUs">关于我们</router-link></li>
						<li><router-link :key="'ResourceCenter'" to="/ResourceCenter">资源中心</router-link></li>
						<li><router-link :key="'FreshmanHub'" to="/FreshmanHub">新人专区</router-link></li>
					</ul>
				</div>
			</div>
		</div>
	</footer>
	<!--/#footer-->
</template>

<style scoped></style>
