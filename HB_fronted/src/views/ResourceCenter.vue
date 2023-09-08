<template>
	<section id="resource-menu">
		<div class="container">
			<div style="display: flex">
				<div class="menu">
					<a-menu
						v-model:selectedKeys="state.selectedKeys"
						style="width: 250px"
						mode="inline"
						:open-keys="state.openKeys"
						:items="items"
						@open-change="onOpenChange"
					></a-menu>
				</div>
				<!-- 导航菜单 ... -->
				<div class="content">
					<a-card
						v-for="resource in filteredResourceList"
						:key="resource.id"
						class="resource-card"
						:title="resource.title"
						:tab-list="tabList"
						:active-tab-key="resource.activeTabKey"
						@tab-change="(key) => onTabChange(key, resource.id)"
					>
						<template #customTab="item">
							<span v-if="item.key === 'brief'" class="tab-item">
								<InfoCircleOutlined class="tab-icon" />
								{{ item.tab }}
							</span>
							<span v-else-if="item.key === 'author'" class="tab-item">
								<UserOutlined class="tab-icon" />
								{{ item.tab }}
							</span>
							<span v-else-if="item.key === 'link'" class="tab-item">
								<DownloadOutlined class="tab-icon" />
								{{ item.tab }}
							</span>
							<!-- 其他 tab 的处理 -->
						</template>
						<template #extra>
							<a :href="resource.link" style="color: #0a53be">More</a>
						</template>
						{{ resource[resource.activeTabKey] }}
					</a-card>
				</div>
			</div>
		</div>
	</section>
</template>
<script lang="ts" setup>
import { computed, h, onMounted, reactive, ref, VueElement, watchEffect } from 'vue';
import { BookOutlined, CommentOutlined, DownloadOutlined, FileOutlined, InfoCircleOutlined, ToolOutlined, UserOutlined } from '@ant-design/icons-vue';
import { ItemType } from 'ant-design-vue';
import axios from 'axios';

const selectedOption = ref('');

function getItem(label: VueElement | string, key: string, icon?: any, children?: ItemType[], type?: 'group'): ItemType {
	return {
		key,
		icon,
		children,
		label,
		type,
	} as ItemType;
}

const tabList = [
	{
		key: 'brief',
		tab: '简介',
	},
	{
		key: 'author',
		tab: '作者',
	},
	{
		key: 'link',
		tab: '下载链接',
	},
];

let resourceList = ref([
	{
		id: 0,
		title: '',
		brief: '',
		author: '',
		link: '',
		label: '',
		activeTabKey: '',
	},
]);

onMounted(() => {
	axios.get('/resource/all').then((response) => {
		const reactivateData = response.data;

		for (const resource of reactivateData) {
			resource.activeTabKey = tabList[0].key;
		}

		resourceList.value = reactivateData;
	});
});

const onTabChange = (key, resourceId) => {
	const resource = resourceList.value.find((item) => item.id === resourceId);
	if (resource) {
		resource.activeTabKey = key;
	}
};

const items: ItemType[] = reactive([
	getItem('软件与工具', 'software', () => h(ToolOutlined), [
		getItem('计算机', 'computer'),
		getItem('机械', 'mechanical'),
		getItem('生物', 'biology'),
	]),
	getItem('文书资料', 'documents', () => h(FileOutlined), [
		getItem('论文模板', 'thesis'),
		getItem('项目文档', 'project'),
		getItem('比赛模板', 'competition', null, [getItem('互联网+', 'internet_plus'), getItem('三创', 'innovation')]),
	]),
	getItem('学习资源', 'study', () => h(BookOutlined), [
		getItem('期末复习', 'final_exam'),
		getItem('专业资料', 'professional'),
		getItem('课外补充', 'extracurricular'),
	]),
	getItem('常见问题与帮助', 'faq', () => h(CommentOutlined), [getItem('常见问题', 'faq_common'), getItem('教程', 'tutorial')]),
]);

const state = reactive({
	rootSubmenuKeys: ['software', 'documents', 'study', 'faq'], // 使用修改后的 key
	openKeys: ['software'], // 初始展开的选项
	selectedKeys: ['computer'],
});

const onOpenChange = (openKeys: string[]) => {
	const latestOpenKey = openKeys.find((key) => state.openKeys.indexOf(key) === -1);
	if (state.rootSubmenuKeys.indexOf(latestOpenKey) === -1) {
		state.openKeys = openKeys;
	} else {
		state.openKeys = latestOpenKey ? [latestOpenKey] : [];
	}
};

const filteredResourceList = computed(() => {
	return resourceList.value.filter((resource) => resource.label === selectedOption.value);
});

// 监听选项变化，更新 selectedOption
watchEffect(() => {
	// 你可以在这里根据 state.selectedKeys 或其他方式获取选中的选项的 key
	selectedOption.value = state.selectedKeys[0] || '';
});
</script>

<style scoped></style>
