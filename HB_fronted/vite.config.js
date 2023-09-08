import { defineConfig } from 'vite';
import vue from '@vitejs/plugin-vue';
import * as path from 'path';
import eslintPlugin from 'vite-plugin-eslint';

// https://vitejs.dev/config/
export default defineConfig({
	plugins: [
		vue(),
		eslintPlugin({
			include: ['src/**/*.ts', 'src/**/*.vue', 'src/*.ts', 'src/*.vue'],
		}),
	],
	resolve: {
		alias: {
			'@': path.resolve(__dirname, 'src'),
		},
	},
	server: {
		https: {
			key: 'ssl/cert.key', // 您的私钥文件路径
			cert: 'ssl/fullchain.cer', // 您的证书文件路径
		},
		port: 5173,
		hot: true,
	},
	publicPath: process.env.NODE_ENV === 'production' ? './' : '/',
});
