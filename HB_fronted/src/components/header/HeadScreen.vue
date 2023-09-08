<template>
	<div class="top-bar">
		<div class="container">
			<div class="row">
				<div class="col-md-6 col-12">
					<div class="top-number">
						<i class="fa-solid fa-phone"></i>
						<p>+86 18295501675</p>
					</div>
				</div>
				<div class="col-md-6 col-12">
					<div class="social" style="display: flex; align-items: center; justify-content: flex-end">
						<ul class="social-share" style="list-style: none; padding: 0; margin: 0">
							<!-- social icons here -->
							<li style="display: inline-block; margin-right: 10px">
								<a href="#" @click="showQQModal"><i class="fa-brands fa-qq"></i></a>
							</li>
							<a-modal :visible="isQQModalVisible" footer="" centered @cancel="hideQQModal">
								<img src="/contact/QQ.jpg" alt="QQ群" style="max-width: 100%" />
							</a-modal>
							<li style="display: inline-block; margin-right: 10px">
								<a><i class="fa-brands fa-weixin"></i></a>
							</li>
						</ul>
						<div class="search">
							<form role="form">
								<input type="text" class="search-form" autocomplete="off" placeholder="Search" />
								<i class="fa fa-search"></i>
							</form>
						</div>
					</div>
				</div>
			</div>
		</div>
		<!--/.container-->
	</div>
	<!--/.top-bar-->

	<nav class="navbar navbar-expand-lg navbar-dark" style="background-color: #1c3657">
		<div class="container">
			<a class="navbar-brand" href="#" style="display: flex; align-items: center" @click="navigateTo('/')">
				<img src="/logo/circle/logo_dark_circle.png" alt="logo" style="max-height: 70px; margin-right: 10px" />
				<span style="display: flex; align-items: center; font-weight: 300; font-family: 'Times New Roman', serif"> 宁湖小筑 </span>
			</a>

			<a-menu mode="horizontal" theme="dark" class="custom-menu">
				<a-menu-item key="home" @click="navigateTo('HomePage')">主页</a-menu-item>
				<a-menu-item key="about" @click="navigateTo('AboutUs')">关于我们</a-menu-item>
				<a-menu-item key="resource" @click="navigateTo('ResourceCenter')">资源中心</a-menu-item>
				<a-menu-item key="freshman" @click="navigateTo('FreshmanHub')">新人专区</a-menu-item>
			</a-menu>
		</div>
		<!--/.container-->
	</nav>
	<!--/nav-->
</template>

<script setup lang="ts">
import { useRoute, useRouter } from 'vue-router';
import { ref } from 'vue';

// 获取路由和导航
const route = useRoute();
const router = useRouter();

// 导航到指定路由
const navigateTo = (routeName: any) => {
	router.push({ name: routeName });
};

const isQQModalVisible = ref(false);

const showQQModal = () => {
	isQQModalVisible.value = true;
};

const hideQQModal = () => {
	isQQModalVisible.value = false;
};
</script>

<style scoped></style>
