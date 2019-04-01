package com.omelchenkoaleks.castomview;

// будет обязывать наш контейнер Вью иметь этот метод ...
interface PaneContainer {
    void showItem(String item);
}
