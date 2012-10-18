package oc.wh40k.units.da;

import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsEinzelZaehler;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.OptionsZaehlerGruppe;
import oc.RefreshListener;

public class DADeathwingTerminatortrupp extends Eintrag {

	OptionsZaehlerGruppe o1;
	OptionsEinzelZaehler o1a;
	OptionsUpgradeGruppe o2;
	OptionsZaehlerGruppe o3;
	OptionsEinzelUpgrade belial1;
	OptionsEinzelUpgrade belial2;

	boolean added = false;

	public DADeathwingTerminatortrupp() {
		name = "5 Deathwing-Terminatoren";
		grundkosten = 215;

		add(ico = new oc.Picture("oc/wh40k/images/DADeathwingTerminatorSquad.gif"));

		seperator();
        
        //add(o1a = new OptionsEinzelZaehler(ID, randAbstand, cnt, "", "E-Faust & SB", "Energiefaust & Sturmbolter", 5, 0));
		ogE.addElement(new OptionsGruppeEintrag("Energieklauenpaar", 0));
		ogE.addElement(new OptionsGruppeEintrag("Hammer & Schild", "Energiehammer & Sturmschild", 0));
		add(o1 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 5));

		ogE.addElement(new OptionsGruppeEintrag("Kettenfaust", 5));
		add(o3 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 5));

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Cyclone-Raketenwerfer", 20));
		ogE.addElement(new OptionsGruppeEintrag("Schwerer Flamer", "Schwerer Flammenwerfer", 5));
		ogE.addElement(new OptionsGruppeEintrag("Sturmkanone", 30));
		add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

		seperator();

		add(belial1 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "DW-Kompaniestandarte", "Deathwing-Kompaniestandarte", 25));
		add(belial2 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Apothecarius", "Upgrade zum Apothecarius", 30));


		String hilfeText = "Dieses Upgrade darf nur von EINER Auswahl in der Armee verwendet werden. Auﬂerdem muss Belial Bestandteil der Armee sein.";

		belial1.setToolTipText(hilfeText);
		belial2.setToolTipText(hilfeText);

	}

	@Override
	public void refreshen() {
        //o1a.setAnzahl(5 - o1.getAnzahl() - o3.getAnzahl());
        //o1a.setMaxAnzahl(5 - o1.getAnzahl() - o3.getAnzahl());

		o2.setAktiv("Schwerer Flammenwerfer", o1.getAnzahl() < 5);
		o2.setAktiv("Sturmkanone", o1.getAnzahl() < 5);
		
		o3.setMaxAnzahl(5 - o1.getAnzahl());

		if (!added && (belial1.isSelected() || belial2.isSelected())) {
			BuildaHQ.addToInformationVector("BelialUpgrade", 1);
			added = true;
			RefreshListener.fireRefresh();
		} else if (added && !belial1.isSelected() && !belial2.isSelected()) {
			BuildaHQ.addToInformationVector("BelialUpgrade", -1);
			added = false;
			RefreshListener.fireRefresh();
		}

		boolean belialLegal = BuildaHQ.getCountFromInformationVector("DABelial") > 0 && BuildaHQ.getCountFromInformationVector("BelialUpgrade") < 2;

		belial1.setLegal(belialLegal || !belial1.isSelected()); // nicht aktivierte Optionen brauchen auch net rot werden. Sieht der Benutzer erst wenn ers kaufen will...
		belial2.setLegal(belialLegal || !belial2.isSelected());
	}

	@Override
	public void deleteYourself() {
		if (added) {
			BuildaHQ.addToInformationVector("BelialUpgrade", -1);
		}

		super.deleteYourself();
	}

}
