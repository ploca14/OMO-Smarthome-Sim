# Smart home
## Popis realisace jednotlivých funkčních požadavků
- **F1 - výčet entit se kterýma se pracuje:** Entity se nacházi v programu pod stejnými jmény.
- **F2 - Stav a API zařízení:** Všechna zařízení mají DeviceState, podle kterého mají spotřebu a API pro měnení tohoto stavu. Se zařízeními může Person interagovat pomocí metody use. Vybrané zařízeni maji Traity, které rozšiřují jejich funkcionalitu. Např. Oven a Microvave maji trait HasCook, který umožňuje vařit jídlo, anebo AC má trait Temperature. Některá zařízení také obsahují nějaký Item, např. Fridge může obsahovat Food, anebo AudioVideoReceiver může obsahovat CD.
- **F3 - Spotřeba zařízení a jejich stav:** DeviceConsumption, DeviceState
- **F4 - API pro sběr dat o spotřebě:** Kazdý Device obsahuje DeviceTracker, který poskytuje API pro sběr spotřeby. Lze ho vyresetovat a měřit tak spotřebu v růžných časových intervalech.
- **F5 - Akce obyvatel na ostatní zařízení a obyvatele**: Se zařízeními mohou Person náhodně interagovat pomocí metody use. Skrz event systém mohou interagovat jak se zařízeními tak i s ostatními obyvateli (např. Device vyhodí IsBroken -> Je náhodně vybrán obyvatel, který poslouchá tento Event a je doma -> přijde a Device opraví). 
- **F6, F7 Event systém**
   - EventPublisher a EventConsumer – Device a Inhabitant jsou EventPublisher a notifikují House, který je EventConsumer o vzniku Eventu.
   - Observer a Observable – Device a Inhabitant jsou Observer a jsou notifikování domem o vzniku Eventu, jehož typ odebírají. Notifikování odběratel o Eventu se vždy děje na konci časové jednotky simulace. Osoby mohou odbavit jakýkoliv Event na jehož odběr se přihlásili, protože se mohou hýbat. Devices odbavují vždy pouze Eventy, které vznikly v místnosti, ve které se nacházejí, protože se nemohou přemístit do jiné mistnosti. O některých událostech je nutné notifikovat všechny relevantní odběratele (např. v místnosti je tma, rozsvítí se tam všechny světla), o některých Eventech je notifikován náhodně vždy jenom jeden odběratel. Např. Kid IsCrying, přijde jenom jeden Adult.
   - Náhodně generované eventy: EventPublisher interface obsahuje metody, pomocí kterých lze určit jaké Eventy bude ten kdo Interface implementuje generovat. 
- **F8 Reporty** - House vystavuje API pro získaní reportů. Např. getEventReport(). Tvorba těchto reportů je řešena skrz jednotlivé visitory (package reports/visitors)
- **F9 Rozbité zařízení** - Každému zařízení je náhodně přidělena nějaký durability, která se v každé iteraci simulace snižuje o konstantní jednotku danou v konfiguraci. Jakmile tato durability klesne pod nulu, tak se zařízení vypne a při interakci zůstavá pořád vypnuté, dokuď někdo neodbaví Event IsBroken a v tomto "odbavování" nezavolá metodu repair na zařízení, která vyžaduje jako argumenty Manual a Warranty.
- **F10 Chození ven** - Na začátku jednotky simualce, se vždy všechny osoby vrátí zpátky domů a pak se náhodně rozhodnou, jestli chcou jít ven, anebo ne. V případě, že uz pro ně nezbývá žádné sprotovní náčiní tak provádějí akce v domě. Na začátku dalšího cyklu se pak pokusí jít ven znovu. Když jsou osoby venku, tak neodbavují ani negenerují Eventy.


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

