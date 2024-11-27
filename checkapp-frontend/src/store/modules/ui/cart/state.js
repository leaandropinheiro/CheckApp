import { loadCartFromLocalStorage, loadDrawerStateFromLocalStorage } from './helpers';

export const state = {
  drawer: loadDrawerStateFromLocalStorage(),
  cart: loadCartFromLocalStorage()
};
