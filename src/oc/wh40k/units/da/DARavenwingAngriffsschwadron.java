package oc.wh40k.units.da;

import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.OptionsZaehlerGruppe;
import oc.RefreshListener;
import oc.RuestkammerStarter;

public class DARavenwingAngriffsschwadron extends Eintrag {

	OptionsUpgradeGruppe trupp;
	OptionsUpgradeGruppe trike;
	OptionsEinzelUpgrade boss;
	OptionsEinzelUpgrade o1;
	OptionsEinzelUpgrade sammael1;
	OptionsEinzelUpgrade sammael2;
	RuestkammerStarter rkBoss;

	boolean added = false;

	public DARavenwingAngriffsschwadron() {
		name = "Ravenwing-Angriffsschwadron";
		grundkosten = 0;
		überschriftSetzen = true;

		add(ico = new oc.Picture("oc/wh40k/images/DARavenwingAttackSquadron.gif"));

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("3 Space Marine Biker", 120));
		ogE.addElement(new OptionsGruppeEintrag("6 Space Marine Biker", 220));
		add(trupp = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Flammenwerfer", 5));
		ogE.addElement(new OptionsGruppeEintrag("Melter", 10));
		ogE.addElement(new OptionsGruppeEintrag("Plasmawerfer", 15));
		add(new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 2));

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Trike (Schwerer Bolter)", "Trike mit Schwerem Bolter", 50));
		ogE.addElement(new OptionsGruppeEintrag("Trike (Multimelter)", "Trike mit Multimelter", 50));
		add(trike = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

		seperator();

		add(o1 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Land Speeder", 100));

		seperator();

		add(sammael1 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "RW-Kompaniestandarte", "Ravenwing-Kompaniestandarte", 25));
		add(sammael2 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Apothecarius", "Upgrade zum Apothecarius", 15));

		String hilfeText = "Dieses Upgrade darf nur von EINER Auswahl in der Armee verwendet werden. Außerdem muss Sammael Bestandteil der Armee sein.";

		sammael1.setToolTipText(hilfeText);
		sammael2.setToolTipText(hilfeText);

		seperator();

		rkBoss = new RuestkammerStarter(ID, randAbstand, cnt, "DASergeant", "Upgrade zum Sergeant");
		rkBoss.initKammer(false, true);
		rkBoss.setUeberschriftTrotzNullKostenAusgeben(true);
		add(rkBoss);
		rkBoss.setAbwaehlbar(false);

		seperator();

		complete();
	}

	@Override
	public void deleteYourself() {
		if (added) {
			BuildaHQ.addToInformationVector("SammaelUpgrade", -1);
		}
		super.deleteYourself();
	}

	@Override
	public void refreshen() {
        if(!rkBoss.isSelected()) rkBoss.setSelected(true);
        
		if (!trupp.isSelected()) {
			trupp.setSelected(0, true);
		}

		if (!added && (sammael1.isSelected() || sammael2.isSelected())) {
			BuildaHQ.addToInformationVector("SammaelUpgrade", 1);
			added = true;
			RefreshListener.fireRefresh();
		} else if (added && !sammael1.isSelected() && !sammael2.isSelected()) {
			BuildaHQ.addToInformationVector("SammaelUpgrade", -1);
			added = false;
			RefreshListener.fireRefresh();
		}

		boolean belialLegal = BuildaHQ.getCountFromInformationVector("DASammael") > 0 && BuildaHQ.getCountFromInformationVector("SammaelUpgrade") < 2;

		sammael1.setLegal(belialLegal || !sammael1.isSelected()); // nicht aktivierte Optionen brauchen auch net rot werden. Sieht der Benutzer erst wenn ers kaufen will...
		sammael2.setLegal(belialLegal || !sammael2.isSelected());
		
		o1.setAktiv(trupp.isSelected("6 Space Marine Biker"));
	}

}
