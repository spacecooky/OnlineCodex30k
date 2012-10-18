package oc.wh40k.units.ig;

import oc.AnzahlPanel;
import oc.BuildaHQ;
import oc.Eintrag;
import oc.OnlineCodex;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.OptionsZaehlerGruppe;

public class IGKavallerieschwadron extends Eintrag {

	AnzahlPanel squad;
	OptionsZaehlerGruppe o1;
	OptionsUpgradeGruppe o2;
	OptionsUpgradeGruppe o3;
	OptionsEinzelUpgrade oe1;

	boolean kamirSelected = false;
	private boolean isDemonHunters = false;
	private boolean isWitchHunters = false;

	public IGKavallerieschwadron() {
		name = "Kavallerieschwadron";
		grundkosten = 0;

		checkDraftOption();
		squad = new AnzahlPanel(ID, randAbstand, cnt, "Kavalleristen", 5, 10, 10);
		squad.setGrundkosten(5);
		add(squad);

		add(ico = new oc.Picture("oc/wh40k/images/IGRoughRaiderSquad.jpg"));

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Flammenwerfer", 5));
		ogE.addElement(new OptionsGruppeEintrag("Granatwerfer", 5));
		ogE.addElement(new OptionsGruppeEintrag("Melter", 10));
		ogE.addElement(new OptionsGruppeEintrag("Plasmawerfer", 15));
		add(o1 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 2));

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Upgrade zum Sergeant", "Upgrade zum Kavalleriesergeant", 0));
		ogE.addElement(new OptionsGruppeEintrag("Upgrade zum Mogul Kamir", 40));
		add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
		o2.setSelected(0, true);

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Energiewaffe", 10));
		ogE.addElement(new OptionsGruppeEintrag("Plasmapistole", 10));
		add(o3 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "option", ogE));

		add(oe1 = new OptionsEinzelUpgrade(ID, randAbstand +10, cnt, "", "Melterbomben", 5));

		complete();
	}

	@Override
	public void refreshen() {
		if(!o2.isSelected()) o2.setSelected(0,true);
		o3.setAktiv(o2.isSelected("Upgrade zum Kavalleriesergeant"));
		oe1.setAktiv(o2.isSelected("Upgrade zum Kavalleriesergeant"));

		// Unique entry: Mogul Kamir
		boolean kamirGlobal = ( BuildaHQ.getCountFromInformationVector("IGMogulKamir") > 0 ? true : false );
		if(kamirGlobal && !kamirSelected) o2.setAktiv("Upgrade zum Mogul Kamir", false);
		else o2.setAktiv("Upgrade zum Mogul Kamir", true);

		if(o2.isSelected("Upgrade zum Mogul Kamir")) {
			kamirSelected = true;
			BuildaHQ.addToInformationVector("IGMogulKamir", 1);
		} else {
			if(kamirSelected) {
				kamirSelected = false;
				BuildaHQ.setInformationVectorValue("IGMogulKamir", 0);
			}
		}

		// Check validity in case of drafted units for Inquisition amries
		if(isDemonHunters || isWitchHunters) {
			int draftTroops = BuildaHQ.getCountFromInformationVector( isDemonHunters ? "DJDraftTroops" : "HXDraftTroops" );
			int choice = BuildaHQ.getCountFromInformationVector("IGRoughRaiderSquad");
			if(draftTroops < 2) {
				setFehlermeldung("Zu wenig IA-Standards!");
			}
			else {
				if(choice > 1 && isDemonHunters) {
					setFehlermeldung("0-1 Auswahl");
				} else {
					setFehlermeldung("");
				}
			}
		}
	}

	private void checkDraftOption() {
		isDemonHunters = OnlineCodex.getInstance().getCurrentArmy().equals("Daemonenjaeger");
		isWitchHunters = OnlineCodex.getInstance().getCurrentArmy().equals("Hexenjaeger");

		if(isDemonHunters || isWitchHunters) {
			BuildaHQ.addToInformationVector("IGRoughRaiderSquad", 1);
		}
	}

	@Override
	public void deleteYourself() {
		if(isDemonHunters || isWitchHunters) {
			BuildaHQ.addToInformationVector("IGRoughRaiderSquad", -1);
		}
        if(o2.isSelected("Upgrade zum Mogul Kamir")) BuildaHQ.setInformationVectorValue("IGMogulKamir", 0);
		super.deleteYourself();
	}

}
