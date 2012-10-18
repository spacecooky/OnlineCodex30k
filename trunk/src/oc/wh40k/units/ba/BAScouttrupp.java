package oc.wh40k.units.ba;

import oc.AnzahlPanel;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.OptionsZaehlerGruppe;
import oc.RuestkammerStarter;

public class BAScouttrupp extends Eintrag {

	AnzahlPanel squad;
	OptionsZaehlerGruppe o1;
	OptionsZaehlerGruppe o1def;
	OptionsEinzelUpgrade o2;
	OptionsUpgradeGruppe o3;
	RuestkammerStarter rkBoss;

	public BAScouttrupp() {
		name = "Scouttrupp\n";
		grundkosten = 0;
		überschriftSetzen = true;

		squad = new AnzahlPanel(ID, randAbstand, cnt, "Scouts", 5, 10, 13);
		add(squad);

		add(ico = new oc.Picture("oc/wh40k/images/BAScouttrupp.jpg"));
		

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Schrotflinte", 0));
		add(o1def = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 0));
		ogE.addElement(new OptionsGruppeEintrag("Bolter", 0));
		ogE.addElement(new OptionsGruppeEintrag("Kampfmesser", 0));
		ogE.addElement(new OptionsGruppeEintrag("Scharfschützengew.", "Scharfschützengewehr", 0));
		add(o1 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 0));

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Schwerer Bolter", "Schwerer Bolter mit Höllenfeuer-Munition", 10));
		ogE.addElement(new OptionsGruppeEintrag("Raketenwerfer", 10));
		add(o3 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

		seperator();

		add(o2 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Tarnmäntel", 0));

		seperator();

		rkBoss = new RuestkammerStarter(ID, randAbstand, cnt, "BAScoutSarge", "Upgrade zum Sergeant");
		rkBoss.initKammer(false, false, true, false, true);
		add(rkBoss);
		rkBoss.setAbwaehlbar(false);

		complete();
	}

	@Override
	public void refreshen() {
        if(!rkBoss.isSelected()) rkBoss.setSelected(true);
        
		int subtractor =  o3.getAnzahl() > 0 ? 1 : 0;
		o1.setMaxAnzahl(squad.getModelle()-1 - subtractor); // heavy weapon
		o1def.setMaxAnzahl(squad.getModelle()-1 - o1.getAnzahl() - subtractor);
		o1def.setAnzahl(0, squad.getModelle()-1 - o1.getAnzahl() - subtractor);
		
		o2.setPreis(squad.getModelle() * 3);
	}

}
