# Application Android LocateUnivNantes
---------

### En quelques mots :
Le but de cette application est de permettre aux étudiants et personnels de l'Université de Nantes de se localiser et de se déplacer au sein des locaux de l'université.
L'application dispose d'un décodeur de QRCodes, d'une gestion des préférences, de l'internationalisation, et d'un affichage dynamique des cartes des bâtiments.
By Adeline Granet, Alexis Linard, M1 ATAL, Université de Nantes - 2014

## Comment lancer l'application ?
Nous recommandons d'effectuer les étapes suivantes :
* Récupérer le code depuis le dépôt https://github.com/allinard/LocateUnivNantes et l'intégrer dans Eclipse
* Télécharger le(s) SDK(s) correspondant(s) à celui (ceux) du (des) terminal(aux) sur lesquels installer l'application
* Lancer l'application :
	* Login : test
	* Mot de passe : test


## Les Activities
Nous avons développé 1 activity par écran. Nous avons donc :
* MainActivity (SplashScreen de 2.5s avec logo application)
* LoginActivity (login du CAS univ nantes)
* ChoixActionActivity (choix entre mode localisation ou navigation)
* ChoixDestinationActivity (choix de la destination dans une liste de batiments)
* ChoixOrigineActivity :
	* ChoixOrigineBatimentActivity (choix de l'origine dans une liste de batiments)
	* ChoixOrigineQRCodeActivity (choix de l'origine par flash qrcode)
* ItineraireActivity (affichage itineraire ou localisation)


## QRCode
Nous avons implémenté la gestion et le décodage de QRCode en utilisant l'API Zxhing. L'Activity ChoixOrigineQRCodeActivity, qui est l'activité ou nous appelons l'API, hérite de DecoderActivity présente dans com.example.locateunivnantes.qr. Le décodage est totalement transparent pour le programmeur.
Chaque QRCode scanné par l'application LocateUnivNantes doit représenter un nom de salle.


## Internationalisation
Notre application gère plusieurs langues :
* Français (par défaut)
* Anglais
* Espagnol
* Portugais
* Chinois
Les labels de l'application en fonction de la langue se trouvent dans res/values-[INDICATIF_LANGUE]/strings.xml, où INDICATIF_LANGUE est l'indicatif de la langue cible (fr pour français, es pour espagnol, zh pour chinois...)


## TODO
* Authentification via le CAS de l'Université de Nantes
* Gestion de la personnalisation : 
	* Couleurs (boutons, fond)
	* Version handicap
* Bug reporter
* Intégration des composants "Wifi triangulation" et "Accéléromètre"
* Calcul de l'itinéraire, et affichage des "drapeaux" indiquant la salle d'origine et de destination


## Conclusion
Cette application est la suite de l'application "Bureau" permettant de gèrer les bâtiments et les salles développée ici : https://github.com/allinard/GUILocateUnivNantes
Des explications sont présentes dans le code commenté, et une présentation Presentation-IHM-GRANET-LINARD-ATAL.pdf (à la racine du dépôt github) décrit en détail le travail effectué