package oc.wh40k.units.ba;

import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.OptionsZaehlerGruppe;
import oc.RefreshListener;
import oc.RuestkammerStarter;

public class BAEhrengarde extends Eintrag {

	OptionsZaehlerGruppe o1;
	OptionsZaehlerGruppe o2;
	OptionsEinzelUpgrade jet;
	OptionsUpgradeGruppe banner;
	OptionsEinzelUpgrade champ;
	OptionsEinzelUpgrade aspirant;
	RuestkammerStarter rkTransport;

	boolean added = false;

	public BAEhrengarde() {
		name = "Ehrengarde\n5 Ehrengardisten";
		grundkosten = 115;
		this.setEintragsCNT(0);
		überschriftSetzen = true;

		BuildaHQ.addToInformationVector("BAHonourGuard", 1);

		add(ico = new oc.Picture("oc/wh40k/images/BAEhrengarde.jpg"));

		seperator();

		add(jet = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Sprungmodule", 50));

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Kompaniestandarte", 15));
		ogE.addElement(new OptionsGruppeEintrag("Ordensbanner", 30));
		add(banner = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
		banner.setToolTipText(1, "Das Ordensbanner darf nur maximal 1x pro Armee gewählt werden.");

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Sturmbolter", 3));
		ogE.addElement(new OptionsGruppeEintrag("Flammenwerfer", 5));
		ogE.addElement(new OptionsGruppeEintrag("Melter", 10));
		ogE.addElement(new OptionsGruppeEintrag("Kombi-Melter", 10));
		ogE.addElement(new OptionsGruppeEintrag("Kombi-Flammenwerfer", 10));
		ogE.addElement(new OptionsGruppeEintrag("Kombi-Plasmawerfer", 10));
		ogE.addElement(new OptionsGruppeEintrag("Flammenpistole", 10));
		ogE.addElement(new OptionsGruppeEintrag("Plasmawerfer", 15));
		ogE.addElement(new OptionsGruppeEintrag("Plasmapistole", 15));
		ogE.addElement(new OptionsGruppeEintrag("Infernus-Pistole", 15));
		ogE.addElement(new OptionsGruppeEintrag("Energiewaffe", 15));
		ogE.addElement(new OptionsGruppeEintrag("Energieklaue", 15));
		ogE.addElement(new OptionsGruppeEintrag("Sturmschild", 20));
		ogE.addElement(new OptionsGruppeEintrag("Energiefaust", 25));
		ogE.addElement(new OptionsGruppeEintrag("Energiehammer", 30));
		add(o1 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 8));

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Melterbomben", 5));
		add(o2 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 5));

		seperator();

		add(champ = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", "Blutchampion", "Upgrade zum Blutchampion", 20));
		add(aspirant = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", "Sanguiniusaspirant", "Upgrade zum Sanguiniusaspirant", 0));

		seperator();

		rkTransport = new RuestkammerStarter(ID, randAbstand, cnt, "BATransporterKammer", "Transporter");
		rkTransport.initKammer(true, true, true, false);
		rkTransport.setButtonText("Transporter");
		add(rkTransport);

		complete();
	}

	@Override
	public void refreshen() {
		o1.setMaxAnzahl(8 - (champ.isSelected() ? 2 : 0)); // nur für Ehrengardisten, nicht Champ + Aspirant
		o2.setMaxAnzahl(4 - (champ.isSelected() ? 1 : 0)); // nur für Ehrengardisten, nicht Champ + Aspirant

		aspirant.setSelected(true); // always active
		rkTransport.setAktiv(!jet.isSelected());

		int selectedSquads = BuildaHQ.getCountFromInformationVector("BAHonourGuard");
		int possibleSquads = BuildaHQ.getCountFromInformationVector("BAHQ");
		if(selectedSquads > possibleSquads) {
			setFehlermeldung("Ehrengarde > " + possibleSquads + "!");
		} else {
			setFehlermeldung("");
		}

		if (!added && banner.isSelected("Ordensbanner")) {
			BuildaHQ.addToInformationVector("BAOrdensbanner", 1);
			added = true;
			RefreshListener.fireRefresh();
		} else if (added && !banner.isSelected("Ordensbanner")) {
			BuildaHQ.addToInformationVector("BAOrdensbanner", -1);
			added = false;
			RefreshListener.fireRefresh();
		}

		banner.setLegal("Ordensbanner", BuildaHQ.getCountFromInformationVector("BAOrdensbanner") < 2);
	}

	@Override
	public void deleteYourself() {
		super.deleteYourself();
		
		BuildaHQ.addToInformationVector("BAHonourGuard", -1);
		
		if(banner.isSelected()) {
			BuildaHQ.addToInformationVector("BAOrdensbanner", -1);
		}
	}

}
