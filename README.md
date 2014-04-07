# Application Android LocateUnivNantes
---------

### En quelques mots :
Le but de cette application est de permettre aux �tudiants et personnels de l'Universit� de Nantes de se localiser et de se d�placer au sein des locaux de l'universit�.
L'application dispose d'un d�codeur de QRCodes, d'une gestion des pr�f�rences, de l'internationalisation, et d'un affichage dynamique des cartes des b�timents.
By Adeline Granet, Alexis Linard, M1 ATAL, Universit� de Nantes - 2014

## Comment lancer l'application ?
Nous recommandons d'effectuer les �tapes suivantes :
* R�cup�rer le code depuis le d�p�t https://github.com/allinard/LocateUnivNantes et l'int�grer dans Eclipse
* T�l�charger le(s) SDK(s) correspondant(s) � celui (ceux) du (des) terminal(aux) sur lesquels installer l'application
* Lancer l'application :
	* Login : test
	* Mot de passe : test


## Les Activities
Nous avons d�velopp� 1 activity par �cran. Nous avons donc :
* MainActivity (SplashScreen de 2.5s avec logo application)
* LoginActivity (login du CAS univ nantes)
* ChoixActionActivity (choix entre mode localisation ou navigation)
* ChoixDestinationActivity (choix de la destination dans une liste de batiments)
* ChoixOrigineActivity :
	* ChoixOrigineBatimentActivity (choix de l'origine dans une liste de batiments)
	* ChoixOrigineQRCodeActivity (choix de l'origine par flash qrcode)
* ItineraireActivity (affichage itineraire ou localisation)


## QRCode
Nous avons impl�ment� la gestion et le d�codage de QRCode en utilisant l'API Zxhing. L'Activity ChoixOrigineQRCodeActivity, qui est l'activit� ou nous appelons l'API, h�rite de DecoderActivity pr�sente dans com.example.locateunivnantes.qr. Le d�codage est totalement transparent pour le programmeur.
Chaque QRCode scann� par l'application LocateUnivNantes doit repr�senter un nom de salle.


## Internationalisation
Notre application g�re plusieurs langues :
* Fran�ais (par d�faut)
* Anglais
* Espagnol
* Portugais
* Chinois
Les labels de l'application en fonction de la langue se trouvent dans res/values-[INDICATIF_LANGUE]/strings.xml, o� INDICATIF_LANGUE est l'indicatif de la langue cible (fr pour fran�ais, es pour espagnol, zh pour chinois...)


## TODO
* Authentification via le CAS de l'Universit� de Nantes
* Gestion de la personnalisation : 
	* Couleurs (boutons, fond)
	* Version handicap
* Bug reporter
* Int�gration des composants "Wifi triangulation" et "Acc�l�rom�tre"
* Calcul de l'itin�raire, et affichage des "drapeaux" indiquant la salle d'origine et de destination


## Conclusion
Cette application est la suite de l'application "Bureau" permettant de g�rer les b�timents et les salles d�velopp�e ici : https://github.com/allinard/GUILocateUnivNantes
Des explications sont pr�sentes dans le code comment�, et une pr�sentation Presentation-IHM-GRANET-LINARD-ATAL.pdf (� la racine du d�p�t github) d�crit en d�tail le travail effectu�