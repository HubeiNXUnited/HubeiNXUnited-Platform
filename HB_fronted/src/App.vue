<script setup>
import HeadScreen from '@/components/header/HeadScreen.vue';
import FooterScreen from '@/components/footer/FooterScreen.vue';
</script>

<template>
	<HeadScreen />
	<router-view />
	<FooterScreen />
</template>

<style scoped></style>
