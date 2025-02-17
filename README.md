# DirectionalPointer

## Описание
**DirectionalPointer** — это мод для Minecraft 1.21 на платформе **Fabric**, заменяющий стандартный прицел на более информативный указатель направления. Он отображает ориентацию игрока в пространстве, аналогично отладочному экрану (F3), но без лишней информации.

> [!CAUTION]
> Мод находится на очень-очень ранней стадии разработки, могут быть ошибки при использовании.

## Возможности
- **Кастомный курсор** вместо стандартного "плюса".
- **Отображение направлений** (север, юг, запад, восток).
- **Индикатор уклона взгляда вверх/вниз**.
- **Настройки размера, прозрачности и активации мода**.

## Установка
1. Установите **Fabric Loader** для Minecraft 1.21.
2. Скачайте и установите **Fabric API**.
3. Скачайте `DirectionalPointer-X.X.X.jar` и поместите его в папку `mods`.

## TODO
### Основной функционал
- [x] Реализовать замену стандартного прицела
- [ ] Отрисовка указателя направлений
  - [ ] Создать текстуры курсора
  - [ ] Отобразить направления (N, S, W, E)
  - [ ] Учесть уклон взгляда (вверх/вниз)
- [ ] Добавить настройки конфигурации
  - [ ] Размер курсора
  - [ ] Прозрачность
  - [ ] Включение/выключение мода

### Дополнительно
- [ ] Интеграция с **ModMenu** для удобного UI-настроек
- [ ] Добавить поддержку **Resource Pack** для кастомных текстур
- [ ] Реализовать совместимость с другими GUI-модификациями
- [ ] Добавить рендер `.obj`.
  - [ ] Базовая отрисовка на основе файла.
    - [ ] Вертексы
    - [ ] Сжатие
  - [ ] Предпросмотр объекта
- [ ] Добавить поддержку кастомных вариаций.
  - [ ] Загрузка `.obj` файлов.
  - [ ] Внутренний стандартный каталог объектов
  - [ ] Внешний каталог объектов