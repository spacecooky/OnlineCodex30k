package oc.wh40k.units.da;

import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsEinzelZaehler;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.OptionsZaehlerGruppe;
import oc.RefreshListener;
import oc.RuestkammerStarter;

public class DAKommandotrupp extends Eintrag {

	OptionsEinzelZaehler championOption;
	OptionsEinzelUpgrade standard;
	OptionsUpgradeGruppe specialStandards;
	RuestkammerStarter ot;

	public DAKommandotrupp() {
		name = "Kommandotrupp";
		grundkosten = 105;
		this.setEintragsCNT(0);

		add(ico = new oc.Picture("oc/wh40k/images/DACommandSquad.gif"));

		seperator();


		add(new OptionsEinzelZaehler(ID, randAbstand, cnt, "", "Plasmapistole", 2, 15));

		seperator(8);

		ogE.addElement(new OptionsGruppeEintrag("Energiewaffe", 15));
		ogE.addElement(new OptionsGruppeEintrag("Energiefaust", 25));
		add(new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 2));

		seperator(8);

		add(new OptionsEinzelZaehler(ID, randAbstand, cnt, "", "Melterbomben", 5, 5));

		seperator(8);

		ogE.addElement(new OptionsGruppeEintrag("Flammenwerfer", 5));
		ogE.addElement(new OptionsGruppeEintrag("Melter", 10));
		ogE.addElement(new OptionsGruppeEintrag("Plasmawerfer", 15));
		add(new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 2));

		seperator();

		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Apothecarius", "Upgrade zum Apothecarius", 20));

		seperator(5);

		ogE.addElement(new OptionsGruppeEintrag("Kompaniestandarte", 10));
		ogE.addElement(new OptionsGruppeEintrag("Heilige Standarte", 15));
		ogE.addElement(new OptionsGruppeEintrag("Dark Angels Ordensbanner", 25));
		add(specialStandards = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

		seperator();

		add(championOption = new OptionsEinzelZaehler(ID, randAbstand, cnt, "", "Kompaniechampion", "Upgrade zum Kompaniechampion", 1, 25));

		seperator();

		ot = new RuestkammerStarter(ID, randAbstand, cnt, "DATransporterKammer", "Transporter");
		ot.initKammer(false, true, true);
		ot.setButtonText("Transporter");
		add(ot);

		complete();
	}

	@Override
	public void deleteYourself() {  // WICHTIG: wird nicht beim Volkwechseln ausgeführt. Dafr wird BuildaHQ.leereChooserGruppenArray(); aufgerufen, was das ersetzt
		if (champions != 0) BuildaHQ.addToInformationVector("CompanyChampion", -champions);
		if (sacred)	BuildaHQ.addToInformationVector("SacredStandard", -1);
		if (chapter) BuildaHQ.addToInformationVector("ChapterBanner", -1);

		super.deleteYourself();
	}

	int champions = 0;
	boolean sacred = false;
	boolean chapter = false;

	@Override
	public void refreshen() {
		// COMPANY CHAMPION
		if (champions != championOption.getAnzahl()) {
			BuildaHQ.addToInformationVector("DACompanyChampion", championOption.getAnzahl() - champions);
			champions = championOption.getAnzahl();
			RefreshListener.fireRefresh();
			return;
		}

		championOption.setLegal(BuildaHQ.getCountFromInformationVector("DAKompaniemeister") >= BuildaHQ.getCountFromInformationVector("DACompanyChampion") || championOption.getAnzahl() <= 0); // wenn nicht ausgewählt brauchs auch net rot zu werden

		// SACRED STANDARD
		boolean optionSelected = specialStandards.isSelected("Heilige Standarte");
		if (sacred != optionSelected) {
			BuildaHQ.addToInformationVector("DAHeiligeStandarte", optionSelected ? 1 : -1);
			sacred = optionSelected;
			RefreshListener.fireRefresh();
			return;
		}

		specialStandards.setLegal("Heilige Standarte", BuildaHQ.getCountFromInformationVector("DAAbsolutionspriester") >= BuildaHQ.getCountFromInformationVector("DAHeiligeStandarte") || !optionSelected); // wenn nicht ausgewählt brauchs auch net rot zu werden

		// CHAPTER BANNER
		optionSelected = specialStandards.isSelected("Dark Angels Ordensbanner");

		if (chapter != optionSelected) {
			BuildaHQ.addToInformationVector("DAChapterBanner", optionSelected ? 1 : -1);
			chapter = optionSelected;
			RefreshListener.fireRefresh();
			return;
		}

		specialStandards.setLegal("Dark Angels Ordensbanner", BuildaHQ.getCountFromInformationVector("DAAzrael") >= BuildaHQ.getCountFromInformationVector("DAChapterBanner") || !optionSelected); // wenn nicht ausgewählt brauchs auch net rot zu werden
	}

}
