<script setup>
import { LeftCircleOutlined, RightCircleOutlined } from '@ant-design/icons-vue';
</script>

<template>
	<!--<editor-fold desc="HomePage Slider">-->
	<div class="carousel-container">
		<a-carousel autoplay arrows effect="fade" style="margin-bottom: 70px">
			<template #prevArrow>
				<div class="custom-slick-arrow" style="left: 10px; z-index: 1">
					<left-circle-outlined />
				</div>
			</template>
			<template #nextArrow>
				<div class="custom-slick-arrow" style="right: 10px">
					<right-circle-outlined />
				</div>
			</template>
			<div><img src="/slider/HomePage/slider1.jpg" alt="bg1" /></div>
			<div><img src="/slider/HomePage/slider2.jpg" alt="bg2" /></div>
			<div><img src="/slider/HomePage/slider3.jpg" alt="bg3" /></div>
			<div><img src="/slider/HomePage/slider4.jpg" alt="bg4" /></div>
			<div><img src="/slider/HomePage/slider5.jpg" alt="bg5" /></div>
		</a-carousel>
	</div>
	<!--</editor-fold>-->

	<section id="feature">
		<div class="container">
			<div class="center" data-aos="fade-down" data-aos-duration="1500">
				<h2>关于我们</h2>
				<p class="lead">在这里，你可以感受到家乡的温暖，也可以共同探索学术的深度。</p>
			</div>

			<div class="row">
				<div class="col-md-4 col-sm-6">
					<div class="feature-wrap" data-aos="fade-down" data-aos-duration="1500">
						<i class="fa fa-bullhorn"></i>
						<h2>生活交流</h2>
						<h3>日常交流，分享生活点滴，畅谈校园近况。</h3>
					</div>
				</div>
				<!--/.col-md-4-->

				<div class="col-md-4 col-sm-6">
					<div class="feature-wrap" data-aos="fade-down" data-aos-duration="1500">
						<i class="fa fa-comments"></i>
						<h2>学术探索</h2>
						<h3>与同学们深入探讨学术话题，共同进步。</h3>
					</div>
				</div>
				<!--/.col-md-4-->

				<div class="col-md-4 col-sm-6">
					<div class="feature-wrap" data-aos="fade-down" data-aos-duration="1500">
						<i class="fa fa-cloud-download"></i>
						<h2>资源分享</h2>
						<h3>共享学习资源，帮助大家更好地学习和成长。</h3>
					</div>
				</div>
				<!--/.col-md-4-->

				<div class="col-md-4 col-sm-6">
					<div class="feature-wrap" data-aos="fade-down" data-aos-duration="1500">
						<i class="fa fa-leaf"></i>
						<h2>湖北文化</h2>
						<h3>一起探讨和传承我们的湖北文化与传统。</h3>
					</div>
				</div>
				<!--/.col-md-4-->

				<div class="col-md-4 col-sm-6">
					<div class="feature-wrap" data-aos="fade-down" data-aos-duration="1500">
						<i class="fa fa-cogs"></i>
						<h2>技能交流</h2>
						<h3>在这里你可以学到各种实用技能，也可以分享你的技能。</h3>
					</div>
				</div>
				<!--/.col-md-4-->

				<div class="col-md-4 col-sm-6">
					<div class="feature-wrap" data-aos="fade-down" data-aos-duration="1500">
						<i class="fa fa-heart"></i>
						<h2>团结互助</h2>
						<h3>我们互相支持，一同成长，为大家提供一个温暖的社群。</h3>
					</div>
				</div>
				<!--/.col-md-4-->
			</div>
			<!--/.row-->
		</div>
		<!--/.container-->
	</section>
	<!--/#feature-->

	<section id="recent-works">
		<div class="container">
			<div class="center" data-aos="fade-down" data-aos-duration="1500">
				<h2>在校生活</h2>
				<p class="lead">在这里，我们分享着在校生活的点滴，共同畅谈校园近况。</p>
			</div>

			<div class="row">
				<div class="col-xs-12 col-sm-4 col-md-3">
					<div class="recent-work-wrap">
						<img class="img-responsive" src="@/assets/images/portfolio/recent/item1.png" alt="" />
						<div class="overlay">
							<div class="recent-work-inner">
								<h3><a href="#">校园活动</a></h3>
								<p>与大家分享校园丰富多彩的活动，留下美好回忆。</p>
								<a class="preview" href="#" rel="prettyPhoto"><i class="fa fa-eye"></i> 查看</a>
							</div>
						</div>
					</div>
				</div>

				<div class="col-xs-12 col-sm-4 col-md-3">
					<div class="recent-work-wrap">
						<img class="img-responsive" src="@/assets/images/portfolio/recent/item2.png" alt="" />
						<div class="overlay">
							<div class="recent-work-inner">
								<h3><a href="#">社团活动</a></h3>
								<p>了解各种社团的活动，参与其中，结交志同道合的朋友。</p>
								<a class="preview" href="#" rel="prettyPhoto"><i class="fa fa-eye"></i> 查看</a>
							</div>
						</div>
					</div>
				</div>

				<div class="col-xs-12 col-sm-4 col-md-3">
					<div class="recent-work-wrap">
						<img class="img-responsive" src="@/assets/images/portfolio/recent/item3.png" alt="" />
						<div class="overlay">
							<div class="recent-work-inner">
								<h3><a href="#">课程分享</a></h3>
								<p>分享学习心得，交流课程内容，共同进步。</p>
								<a class="preview" href="#" rel="prettyPhoto"><i class="fa fa-eye"></i> 查看</a>
							</div>
						</div>
					</div>
				</div>

				<div class="col-xs-12 col-sm-4 col-md-3">
					<div class="recent-work-wrap">
						<img class="img-responsive" src="@/assets/images/portfolio/recent/item4.png" alt="" />
						<div class="overlay">
							<div class="recent-work-inner">
								<h3><a href="#">新生见面会</a></h3>
								<p>与学长学姐交流，展望未来发展。</p>
								<a class="preview" href="#" rel="prettyPhoto"><i class="fa fa-eye"></i> 查看</a>
							</div>
						</div>
					</div>
				</div>
			</div>
			<!--/.row-->
		</div>
		<!--/.container-->
	</section>
	<!--/#recent-works-->

	<section id="partner">
		<div class="container">
			<div class="center" data-aos="fade-down" data-aos-duration="1500">
				<h2>合作伙伴</h2>
				<p class="lead">与合作伙伴们一起，共同构建更好的未来。</p>
			</div>

			<div class="partners">
				<ul>
					<li>
						<a href="#">
							<img class="img-partner" data-aos="fade-down" data-aos-duration="1500" src="/logo/AlphaLab-Logo.png" alt="AlphaLabLogo" />
						</a>
					</li>
				</ul>
			</div>
		</div>
		<!--/.container-->
	</section>
	<!--/#partner-->
</template>

<style scoped>
/* For demo */
.carousel-container {
	width: 100%; /* 调整为你想要的宽度 */
	height: 870px;
	margin: 0 auto; /* 居中轮播图 */
}

:deep(.slick-slide) {
	text-align: center;
	height: 870px;
	line-height: 0; /* 将行高设为0，防止图片与文字之间产生额外的空白间距 */
	background: #364d79;
	overflow: hidden;
}

:deep(.slick-slide) img {
	display: block;
	width: 100%;
	min-height: 870px;
	object-fit: cover;
}

:deep(.slick-arrow.custom-slick-arrow) {
	width: 50px;
	height: 50px;
	font-size: 50px;
	color: #fff;
	background-color: rgba(31, 45, 61, 0);
	transition: ease all 0.3s;
	opacity: 0.3;
	z-index: 1;
}
:deep(.slick-arrow.custom-slick-arrow:before) {
	display: none;
}
:deep(.slick-arrow.custom-slick-arrow:hover) {
	color: #fff;
	opacity: 0.5;
}
</style>
