# Smart home
## Popis realisace jednotlivých funkčních požadavků
- **F1 - výčet entit se kterýma se pracuje:** Entity se nacházi v programu pod stejnými jmény.
- **F2 - Stav a API zařízení:** Všechna zařízení mají DeviceState, podle kterého mají spotřebu a funkcionalitu. Se zařízeními může Person interagovat pomocí metody use. Vybrané zařízeni maji Traity, které rozšiřují jejich funkcionalitu. Např. Oven a Microvave maji trait HasCook, který umožňuje vařit jídlo, anebo AC má trait Temperature. Některá zařízení také obsahují nějaký Item, např. Fridge může obsahovat Food, anebo AudioVideoReceiver může obsahovat CD.
- **F3 - Spotřeba zařízení a jejich stav:** DeviceConsumption, DeviceState
- **F4 - API pro sběr dat o spotřebě:** Kazdý Device obsahuje DeviceTracker, který poskytuje API pro sběr spotřeby. Lze ho vyresetovat a měřit tak spotřebu v růžných časových intervalech.
- **F5 - Akce obyvatel na ostatní zařízení a obyvatele**


## Použité design patterny (A třídy kde je lze najít):
- State machine - DeviceState, CookState
- Iterator – SmartHomeIterator, RoomIterator
- Factory/Factory method – AbstractHouseFactory, OrdinaryHouseFactory, LuxuriousHouseFactory, RoomFactory
- Builder – FloorBuilder, RoomBuilder
- Singleton – House, OutsideWorld, Configuration (Singletony nejsou thread-safe, protože v zadání je napsáno, že aplikace má běžet pouze v jednom vlákně.)
- Visitor - reports/visitors, Eventy (např. IsBroken)
- Observer/Event listener - EventConsumer, EventPublisher, Observer, Observable
- Object Pool – ManualPool, předpokládáme, že Manual je pro každý druh zařízení vždycky stejný, takže pro každou třídu zařízení se v případě nutnosti vytvoří vždy pouze jenom jeden manuál.
- Lazy Initialization – Device.getWarranty()
- Immutable objekty - DeviceConsumption, DeviceConsumptionRate
- Traits - HasCook, Brightness. Snažili jsme se lehce inspirovat tím jak je řešeno API od google smart home. (https://developers.google.com/assistant/smarthome/traits)

## Zajímavý design??
### Generický iterátor
V průběhu implementace semestrálky jsme potřebovali procházet všechny druhy objektů, které se mohou vyskytovat v nějaké místnosti. Zprvu jsme implementovali iterátor pro každý takový objekt zvlášť, ale později jsme zjistili, že logika pro procházení je vlastně pokaždé stejná, takže jsme se iterátor pro objekty, které jsou přímo v místnosti rozhodli udělat generický (**třída SmartHomeIterator**). 

### Immutable spotřeba zařízení
Spotřebu zařízení trackuje třída **DeviceTracker**, kde jsme se snažili inspirovat jedním z prvních cvik, kde jsme psali tracker na měření ujetých kilometrů. Samotnou spotřebu jsme se pak rozhodli implementovat pomocí immutable objektů (třída **DeviceConsumption**), aby se nemohlo stát, že spotřeba na zařízení bude nějakou chybou nedopatřením změnena někde jinde v kódu. Její API jsme se rozhodli udělat po vzoru jiných immutable tříd v Jave (např. Money.of()).

