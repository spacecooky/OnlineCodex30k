package oc.wh40k.units.ty;

import oc.AnzahlPanel;
import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.RuestkammerStarter;

public class TYCarnifexRotte extends Eintrag {

	AnzahlPanel squad;
	OptionsUpgradeGruppe o1;
	OptionsUpgradeGruppe o2;
	OptionsEinzelUpgrade oe1;
	OptionsEinzelUpgrade oe2;
	OptionsEinzelUpgrade oe3;
	OptionsEinzelUpgrade oe4;
	OptionsEinzelUpgrade oe5;
	RuestkammerStarter pod;

	public TYCarnifexRotte() {
		name = "Carnifex-Rotte";
		grundkosten = 0;

		squad = new AnzahlPanel(ID, randAbstand, cnt, "Carnifex", "Carnifexe", 1, 3, 160);
		add(squad);

		add(ico = new oc.Picture("oc/wh40k/images/TYCarnifex.jpg"));

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Sensenklauen", 0));
		ogE.addElement(new OptionsGruppeEintrag("Scherenklauen", 25));
		ogE.addElement(new OptionsGruppeEintrag("Sync. Säurespucker", "Synchronisierte Säurespucker", 15));
		ogE.addElement(new OptionsGruppeEintrag("Sync. Neuralfresser", "Synchronisierte Neuralfresser mit Hirnwürmern", 15));
		add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
		o1.setSelected(0, true);

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Sensenklauen", 0));
		ogE.addElement(new OptionsGruppeEintrag("Sync. Säurespucker", "Synchronisierte Säurespucker", 15));
		ogE.addElement(new OptionsGruppeEintrag("Sync. Neuralfresser", "Synchronisierte Neuralfresser mit Hirnwürmern", 15));
		ogE.addElement(new OptionsGruppeEintrag("Dornenwürgerkanone", 20));
		ogE.addElement(new OptionsGruppeEintrag("Schwere Biozidkanone", 25));
		add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
		o2.setSelected(0, true);

		seperator();

		add(oe1 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Stachelporen", 5));
		add(oe2 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Adrenalindrüsen", 10));
		add(oe3 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Toxinkammern", 10));
		add(oe4 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Bioplasma", 20));
		add(oe5 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Regeneration", 25));

		seperator();

		pod = new RuestkammerStarter(ID, randAbstand, cnt, "TYLandungsspore", "Landungsspore");
		pod.initKammer();
		add(pod);

		complete();
	}

	@Override
	public void refreshen() {
        o1.alwaysSelected();
        o2.alwaysSelected();

		pod.setAktiv(squad.getModelle() == 1);
		
		o1.setPreis(1, squad.getModelle() * 25);
		o1.setPreis(2, squad.getModelle() * 15);
		o1.setPreis(3, squad.getModelle() * 15);

		o2.setPreis(1, squad.getModelle() * 15);
		o2.setPreis(2, squad.getModelle() * 15);
		o2.setPreis(3, squad.getModelle() * 20);
		o2.setPreis(4, squad.getModelle() * 25);

		oe1.setPreis(squad.getModelle() * 5);
		oe2.setPreis(squad.getModelle() * 10);
		oe3.setPreis(squad.getModelle() * 10);
		oe4.setPreis(squad.getModelle() * 20);
		oe5.setPreis(squad.getModelle() * 25);
	}

}
