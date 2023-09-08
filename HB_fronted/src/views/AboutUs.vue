<template>
	<section id="about-us">
		<div class="container">
			<div class="center" data-aos="fade-down" data-aos-duration="1500">
				<h2>关于 HubeiNXUnited</h2>
				<p class="lead">
					宁湖小筑是由湖北籍学生组成的集体。我们利用在线社交媒体，构建了一个温暖的社群。
					<br />
					我们提供线上互动平台，鼓励学生交流、分享成果，并定期举办活动促进合作。
					<br />
					无论您是为学术而努力，还是追求卓越，都欢迎您加入我们。
					<br />
					让我们共同书写辉煌篇章，为未来贡献力量。
				</p>
			</div>
			<!-- about us slider -->
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
					<div><img src="/slider/aboutUs/pic1.jpg" alt="pic1" /></div>
					<div><img src="/slider/aboutUs/pic2.jpg" alt="pic2" /></div>
					<div><img src="/slider/aboutUs/pic3.jpg" alt="pic3" /></div>
				</a-carousel>
			</div>
			<!--/#about-slider-->
		</div>
	</section>

	<section class="dark-div">
		<div class="container">
			<!-- our-team -->
			<!-- 成员组成 -->
			<div class="team">
				<div class="center" data-aos="fade-down" data-aos-duration="1500">
					<h2>成员组成</h2>
					<p class="lead">
						宁湖小筑是由湖北籍学生组成的热情组织。
						<br />我们的成员来自各个专业，欢迎所有在校生的加入。您可以与来自不同领域的校友交流经验和未来憧憬。
						<br />我们举办活动，如讲座和社交聚会，增强校内交流。 加入我们，拓展人脉，获取学术与职业资源，共同成长。
						<br />无论您是新生还是资深学子，宁湖小筑欢迎您。 一起创造美好回忆和活力社区。
					</p>
				</div>
			</div>
			<!--section-->

			<!--MemberList-->
			<div style="text-align: center">
				<div class="select-group">
					<span>学院：</span>
					<a-select :value="selectedCollege" style="width: 150px; text-align: left" @change="handleCollegeChange">
						<a-select-option v-for="college in colleges" :key="college" :value="college">{{ college }} </a-select-option>
					</a-select>
				</div>

				<div class="select-group">
					<span>年级：</span>
					<a-select :value="selectedGrade" style="width: 150px; text-align: left" @change="handleGradeChange">
						<a-select-option v-for="grade in gradeOptions" :key="grade.value" :value="grade.value">{{ grade.label }} </a-select-option>
					</a-select>
				</div>

				<!-- Member Card -->
				<div class="card-container">
					<a-card v-for="student in sortedStudents" :key="student.id" class="message-card" hoverable @click="showStudentDetails(student)">
						<template #cover>
							<img :alt="student.name" :src="student.imgUrl" />
						</template>
						<a-card-meta :title="student.name">
							<template #description>{{ student.email }}</template>
						</a-card-meta>
					</a-card>
				</div>

				<!-- 学生详情模态框 -->
				<a-modal v-model:open="open" :title="selectedStudent.name" @ok="closeStudentDetailsModal">
					<div class="row justify-content-center align-items-center">
						<a-image :width="200" :src="selectedStudent.imgUrl" class="col-sm-12" />
					</div>
					<br />
					<div class="row">
						<div class="col-sm-6 justify-content-center align-items-center">
							<p><strong>姓名：</strong>{{ selectedStudent.name }}</p>
							<p><strong>性别：</strong>{{ selectedStudent.gender }}</p>
							<p><strong>学龄：</strong>{{ selectedStudent.enrollmentYear }}</p>
							<p><strong>学院：</strong>{{ selectedStudent.collegeName }}</p>
						</div>
						<div class="col-sm-6 justify-content-center align-items-center">
							<p><strong>学院所属：</strong>{{ selectedStudent.aclName }}</p>
							<p><strong>家乡：</strong>{{ selectedStudent.hometown }}</p>
							<p><strong>Email：</strong>{{ selectedStudent.email }}</p>
							<p><strong>电话：</strong>{{ selectedStudent.phone }}</p>
						</div>
					</div>
					<template #footer>
						<!-- 这里没有任何内容，因此底部不会显示任何按钮 -->
					</template>
				</a-modal>
			</div>
		</div>
		<!--/.container-->
	</section>
	<!--/about-us-->
</template>

<script setup lang="ts">
import { LeftCircleOutlined, RightCircleOutlined } from '@ant-design/icons-vue';
import { computed, onMounted, ref } from 'vue';
import axios from 'axios';

const selectedCollege = ref('全部学院');
const selectedGrade = ref(-1);
let colleges = [];
const gradeOptions = [
	{ label: '所有年级', value: -1 },
	{ label: '大一', value: 1 },
	{ label: '大二', value: 2 },
	{ label: '大三', value: 3 },
	{ label: '大四', value: 4 },
];
let students = ref([
	{
		id: 0,
		name: '',
		gender: '',
		birthDate: '',
		enrollmentYear: 0,
		collegeName: '',
		aclName: '',
		hometown: '',
		email: '',
		phone: '',
		createdAt: '',
		imgUrl: '',
	},
]);

onMounted(() => {
	axios
		.get('/members/all')
		.then((response) => {
			students.value = response.data;

			//统计学院信息
			const collegeSet = new Set();
			for (const entry of response.data) {
				collegeSet.add(entry.collegeName);
			}
			colleges = ['全部学院', ...Array.from(collegeSet)];
		})
		.catch((error) => {
			console.error('获取数据出错', error);
		});
});

const open = ref<boolean>(false);
const selectedStudent = ref({
	id: 0,
	name: '',
	gender: '',
	birthDate: '',
	enrollmentYear: 0,
	collegeName: '',
	aclName: '',
	hometown: '',
	email: '',
	phone: '',
	createdAt: '',
	imgUrl: '',
});

const showStudentDetails = (student: any) => {
	selectedStudent.value = student;
	open.value = true;
};

const closeStudentDetailsModal = () => {
	open.value = false;
	selectedStudent.value = null;
};

const filteredStudents = computed(() => {
	if (selectedCollege.value === '全部学院' && selectedGrade.value === -1) {
		return students.value;
	}
	if (selectedCollege.value === '全部学院') {
		return students.value.filter((student) => student.enrollmentYear === selectedGrade.value);
	}
	if (selectedGrade.value === -1) {
		return students.value.filter((student) => student.collegeName === selectedCollege.value);
	}
	return students.value.filter((student) => student.collegeName === selectedCollege.value && student.enrollmentYear === selectedGrade.value);
});

//排序选择出的学生
const sortedStudents = computed(() => {
	const filtered = filteredStudents.value.slice(); // 复制筛选后的学生数组

	return filtered.sort((a, b) => a.id - b.id);
});

const handleCollegeChange = (value: string) => {
	selectedCollege.value = value;
};

const handleGradeChange = (value: number) => {
	selectedGrade.value = value;
};
</script>

<style scoped>
/* For demo */
.carousel-container {
	max-width: 1200px; /* 调整为你想要的宽度 */
	margin: 0 auto; /* 居中轮播图 */
}

:deep(.slick-slide) {
	display: flex !important;
	align-items: center; /* 垂直居中 */
	justify-content: center; /* 水平居中 */
	height: auto;
	line-height: 0; /* 将行高设为0，防止图片与文字之间产生额外的空白间距 */
	background: transparent; /* 将背景改为透明 */
	overflow: hidden;
}

:deep(.slick-slide) img {
	display: block;
	width: 100%;
	min-height: 500px;
	object-fit: cover;
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
</style>
