путь
SteamLibrary\steamapps\common\dota 2 beta\game\dota_addons\testusido
это основ папка которая вродебы содержит открытый контент 
кастомок который ты грузишь себе на комп

а это
Q:\SteamLibrary\steamapps\common\dota 2 beta\content\dota_addons\testusido
вродебы папка которая ток у тя(у deva) на компе

или наоборот хз крч, но работал я всегда в game\dota_addons


остальное хз
забросил это дело когда понял что нельзя своего героя сделать 
тольк изменить существующего + все скрипты скрыты и нельзя точно 
узнать че да как работает, офиц документация послана самими 
разрабами, ну над ней работают тольк полтора человека и то
раз в месяц раз в обед.

Все что удалось отрыть в гитхабе это скорее всего даже не полные 
файлы десятилетней давности, те самые файлы которые скрыло само валв

тут я пытался реализовать задумку с домиком который спавнит 
крипсов, где домик это герой а крипсы это его юниты как медведь 
у лон друида, только крипсы не заменяются с прокачкой скила 
спавна крипов у основного героя(домика)(как у лон друида), а 
качают левел деля меж собой эксп и какуюто часть отсылают герою 
который постройка возле трона

у лон друида на данный момент с врожденной способностью 5 
левелов у скила медведя, в файлах игры 5 различных нпс медведей 
и они вродебы по файлам десятилетней давности заменяются при апе 
левела, но как у них предметы в инвентаре сохраняются полное хз 
думаю это неполнота файлов

героя своего сделать нельзя тк прост нет инструментов для этого
(вродебы нету) думаю там у каждого героя помимо объявления в тхт 
файле и папкой с lua скилами есть еще куча какихто файлов... и 
они все скрытые как и наверное многие строки в тхт файле 
объявления гроев.

Я остановился на попытке реализовать скил с призывом крипов, он 
у меня получился , но не получилось с дележкой опыта, в доте нет 
вообще понятия чтобы крипы получали опыт(только герои), у всех 
нейтралов есть скрытый скил(узнал я о нем в тхт файле который 
объявляет нпс) который апает им левел, его найти я даже не 
пробывал... да мб можно было бы изменить в нем параметры найдя 
старый прототип на просторах инета... но у меня еге завтра + 
нельзя своего героя сделать... + у валв 100% еще куча скрытых 
файлов которые отвечают за игру о которых я вообще не знаю а они 
очень важны.

В планах у меня было 3-4 крипа которые похожи на лайновых но мб 
прост цветом другие(оранжевые) один крип маг с 1 актив дпс 
скилом 1 аое дпс скилом и аое тепкой которая тепнет как обычное 
тп всех союзных подконтрольных домику крипов (мб у основ героя 
которых их спавнит можно в таланты пихнуть чето чтоб дополнять 
список или в аган или в шрад или еще чето можно чтото придумать 
100% чтоб там сьел этот домик-герой чето там хз большой лотус к 
примеру...) И 2-3 милишника, один агилити другой силовик их 
спелы я вообще не думал (маг инта естестн, а мб и милишники 
универсалы... или в аспект/талант пихнуть либо им либо таверу их универсальность)


полезные ресурсы :
ю канал крутого чела ваще топ и рофлы и дело ваще красава :
https://www.youtube.com/@CoolStoryBob-or6hv

прога для открытия фалов валвов(вроде файлов для движок сурс2):
https://soft.mydiv.net/win/download-GCFScape.html

lua тутор: https://gcup.ru/publ/programming/lua_tutorial_dlja_nachinajushhikh/8-1-0-623

документац валве : 
https://developer.valvesoftware.com/wiki/Dota_2_Workshop_Tools/Scripting/API#CDOTA_BaseNPC_Hero

полезный сайт для поиска функций и аргументов для них, там еще можно по гиту материалы поискать крч ваще топ : 
https://moddota.com/api/#!/vscripts?search=search


все эти ссылки я у кул стори боба вычерпал как и все свои знания(почти)

файл в котором тхт файлы системные определения нпс и героев :
Q:\SteamLibrary\steamapps\common\dota 2 beta\game\dota\pak01_dir.vpk
там внутри надо зайти в scripts\npc вроде и там все будет, есч у кул стори боба все видео объяснения


еще
 этот файл лежал в этой папке и весил 95% от всего размера папки : tools_thumbnail_cache.bin что сказала нейронка на его счет :

 Файл tools_thumbnail_cache.bin - это файл, который используется для кэширования миниатюр и предварительных просмотров (thumbnails) в инструментах разработки Dota 2 Workshop Tools.

Этот файл помогает ускорить процесс загрузки и отображения миниатюрных изображений ресурсов, таких как моделей, текстур и других ассетов, при работе с различными ресурсами в инструментах разработки Dota 2 Workshop Tools.

Он сохраняет кэшированные версии миниатюр для экономии времени при последующих запросах к ним в процессе работы над кастомными игровыми контентом.

Конечно, важно учитывать, что информация о конкретных типах и версиях файлов может изменяться со временем в зависимости от обновлений и изменений в Dota 2 Workshop Tools. 🎮🔧

я его удалю тк он весит 150мб