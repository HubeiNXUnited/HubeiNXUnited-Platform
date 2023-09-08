<template>
	<section id="feature" class="transparent-bg">
		<div class="container">
			<div class="get-started center" data-aos="fade-down" data-aos-duration="1500">
				<h2>欢迎来到宁夏</h2>
				<p class="lead">
					亲爱的老乡，我们非常高兴你能够选择加入我们的大家庭!
					<br />
					无论是学术探索、社团活动，还是丰富多彩的校园生活，你都将在这里找到属于自己的精彩旅程。
				</p>
				<div class="request">
					<h4><a href="#">了解更多</a></h4>
				</div>
			</div>
			<!--/.get-started-->
		</div>
	</section>

	<section id="map" class="dark-div">
		<div class="container">
			<div class="center" data-aos="fade-down" data-aos-duration="1500">
				<h2>校园地图</h2>
				<div class="carousel-container">
					<a-carousel autoplay arrows :dots="false" effect="fade" style="margin-bottom: 70px">
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
						<div class>
							<a-image src="/map/A-map.jpg" alt="贺兰山校区地图" />
							<h3>贺兰山校区(A区)地图</h3>
						</div>
						<div>
							<a-image src="/map/B-map1.jpg" alt="怀远校区地图(1)" />
							<h3>怀远校区(B区)地图(1)</h3>
						</div>
						<div>
							<a-image src="/map/B-map2.jpg" alt="怀远校区地图(2)" />
							<h3>怀远校区(B区)地图(2)</h3>
						</div>
						<div>
							<a-image src="/map/B-map3.jpg" alt="怀远校区地图(3)" />
							<h3>怀远校区(B区)地图(3)</h3>
						</div>
						<div>
							<a-image src="/map/C-map1.jpg" alt="文萃校区地图(1)" />
							<h3>文萃校区(C区)地图(1)</h3>
						</div>
						<div>
							<a-image src="/map/C-map2.jpg" alt="文萃校区地图(2)" />
							<h3>文萃校区(C区)地图(2)</h3>
						</div>
						<div>
							<a-image src="/map/C-map3.jpg" alt="文萃校区地图(3)" />
							<h3>文萃校区(C区)地图(3)</h3>
						</div>
					</a-carousel>
				</div>
			</div>
		</div>
	</section>

	<section id="contact-info">
		<div class="center">
			<h2>联系我们?</h2>
		</div>
		<div class="gmap-area">
			<div class="container">
				<div class="row justify-content-center">
					<!-- 使用 justify-content-center 来使内容水平居中 -->
					<div class="col-sm-8 text-center">
						<div id="map-container" class="gmap"></div>
					</div>

					<div class="col-sm-4 map-content align-items-center">
						<ul class="row">
							<li class="col-sm-12">
								<address>
									<h5>总部地址</h5>
									<p>宁夏回族自治区 银川市 西夏区 贺兰山西路</p>
									<p>
										电话：+86 18295501675 <br />
										邮箱：liu_hangming@126.com
									</p>
								</address>
							</li>
						</ul>
					</div>
				</div>
			</div>
		</div>
	</section>
	<!--/gmap_area -->

	<section id="contact-page">
		<div class="container">
			<div class="center">
				<h2>留下个人信息</h2>
				<p class="lead">请填写您的个人信息，感谢您的支持。</p>
			</div>
			<div class="row contact-wrap">
				<div class="status alert alert-success" style="display: none"></div>
				<form id="main-contact-form" class="contact-form" name="contact-form" method="post" action="sendemail.php">
					<div class="row text-center">
						<div class="form-group col-sm-6">
							<label>Name *</label>
							<input type="text" name="name" class="form-control" required="required" />
						</div>
						<div class="form-group col-sm-6">
							<label>Email *</label>
							<input type="email" name="email" class="form-control" required="required" />
						</div>
					</div>
					<div class="row text-center">
						<div class="form-group col-sm-6">
							<label>Phone</label>
							<input type="number" class="form-control" />
						</div>
						<div class="form-group col-sm-6">
							<label>Grade</label>
							<input type="text" class="form-control" />
						</div>
					</div>
					<div class="row">
						<div class="col-sm-12 text-center">
							<div class="form-group">
								<label>Message *</label>
								<textarea id="message" name="message" required="required" class="form-control" rows="8"></textarea>
							</div>
							<div class="form-group">
								<button type="submit" name="submit" class="btn btn-primary btn-lg" required="required">Submit Message</button>
							</div>
						</div>
					</div>
				</form>
			</div>
			<!--/.row-->
		</div>
		<!--/.container-->
	</section>
	<!--/#contact-page-->
</template>

<script setup lang="ts">
import { LeftCircleOutlined, RightCircleOutlined } from '@ant-design/icons-vue';
import AMapLoader from '@amap/amap-jsapi-loader';
import { shallowRef } from 'vue';
import { onMounted } from 'vue';
import { useStore } from 'vuex';

const map = shallowRef(null);
const store = useStore();

const initMap = () => {
	// window._AMapSecurityConfig = {
	// 	securityJsCode: store.state.mapOption.securityJsCode,
	// };
	AMapLoader.load(store.state.mapOption.option).then((AMap) => {
		const map = new AMap.Map('map-container', {
			//设置地图容器id
			viewMode: '2D', //是否为3D地图模式
			zoom: 16, //初始化地图级别
			center: [106.13701, 38.500886], //初始化地图中心点位置
		});
		const layers = [new AMap.TileLayer.Satellite(), new AMap.TileLayer.RoadNet()];
		map.setLayers(layers);
	});
};

onMounted(() => {
	initMap();
});
</script>

<style scoped>
.carousel-container {
	max-height: 1000px; /* 调整为你想要的高度 */
	margin: 0 auto; /* 居中轮播图 */
}

:deep(.slick-slide) {
	display: flex !important;
	align-items: center !important; /* 垂直居中 */
	justify-content: center !important; /* 水平居中 */
	height: auto;
	line-height: 0; /* 将行高设为0，防止图片与文字之间产生额外的空白间距 */
	background: transparent; /* 将背景改为透明 */
	overflow: hidden;
}

:deep(.slick-slide) a-image {
	max-height: 100%; /* 让图片充满整个容器 */
	max-width: 100%; /* 让图片充满整个容器 */
	margin-bottom: 10px;
}

:deep(.slick-arrow.custom-slick-arrow) {
	width: 50px;
	height: 50px;
	font-size: 50px;
	color: black;
	background-color: rgba(31, 45, 61, 0);
	transition: ease all 0.3s;
	opacity: 0.3;
	z-index: 1;
}
:deep(.slick-arrow.custom-slick-arrow:before) {
	display: none;
}
:deep(.slick-arrow.custom-slick-arrow:hover) {
	color: black;
	opacity: 0.5;
}

.center-div {
	position: absolute;
	top: 50%;
	left: 50%;
	transform: translate(-50%, -50%);
}
</style>
