package oc.whfb.units.og2004;

import oc.AnzahlPanel;
import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.OptionsZaehlerGruppe;
import oc.RuestkammerStarter;

public class OG2004RhinoxReiter extends Eintrag {

	AnzahlPanel squad;
	OptionsUpgradeGruppe o1;
	OptionsZaehlerGruppe o2;
	OptionsEinzelUpgrade oe1;
	OptionsEinzelUpgrade oeM;
	OptionsEinzelUpgrade oeS;
	OptionsEinzelUpgrade oeC;
	RuestkammerStarter rkBanner;
	
	public OG2004RhinoxReiter() {
		name = BuildaHQ.translate("Rhinox-Reiter");
		grundkosten = 0;

		squad = new AnzahlPanel(ID, randAbstand, cnt, BuildaHQ.translate("Rhinox-Reiter"), 1, 3, 100);
		squad.setGrundkosten(0);
		add(squad);

		add(ico = new oc.Picture("oc/images/OGRhinoxReiter.jpg"));

		seperator();

		add(oe1 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", BuildaHQ.translate("Eisenfäuste"), 10));

		seperator();

		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Leichte Rüstung"), 0));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Schwere Rüstung"), 6));
		add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
		o1.setSelected(0, true);

		seperator();

		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Rhinoxbullen"), BuildaHQ.translate("Upgrade zum Rhinoxbullen"), 45));
		add(o2 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 1));

		seperator();

		add(oeM = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", BuildaHQ.translate("Musiker"), 12));
		add(oeC = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", BuildaHQ.translate("Champion"), 24));
		add(oeS = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", BuildaHQ.translate("Standartenträger"), 24));

		seperator();

		rkBanner = new RuestkammerStarter(ID, randAbstand, cnt, "OG2004Banner", "");
		rkBanner.initKammer(true, false);
		rkBanner.setButtonText(BuildaHQ.translate("Magische Standarte"));
		rkBanner.setUeberschriftTrotzNullKostenAusgeben(true);
		add(rkBanner);
		
		complete();
	}

	@Override
	public void refreshen() {		
		oe1.setPreis(squad.getModelle() * 10);
		o1.setPreis(1, squad.getModelle() * 6);
		if(!o1.isSelected()) o1.setSelected(0, true);
		o2.setMaxAnzahl(squad.getModelle());
		rkBanner.setAktiv(oeS.isSelected());
	}
}
