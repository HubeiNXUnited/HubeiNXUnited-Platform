import { createStore } from 'vuex';
import mapOption from './modules/mapOption';

interface State {
	userName: string;
}
export default createStore({
	modules: {
		mapOption: mapOption,
	},
	state(): State {
		return {
			userName: 'vuex',
		};
	},
});
