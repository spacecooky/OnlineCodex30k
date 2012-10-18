package oc.wh40k.units.ty;

import oc.AnzahlPanel;
import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.RuestkammerStarter;

public class TYTyranidenkrieger extends Eintrag {

	AnzahlPanel squad;
	OptionsUpgradeGruppe o1;
	OptionsUpgradeGruppe o2;
	OptionsUpgradeGruppe o3;
	OptionsEinzelUpgrade oe1;
	OptionsEinzelUpgrade oe2;
	RuestkammerStarter pod;

	public TYTyranidenkrieger() {
		name = "Tyranidenkrieger";
		grundkosten = 0;

		squad = new AnzahlPanel(ID, randAbstand, cnt, "Tyranidenkrieger", 3, 9, 30);
		add(squad);

		seperator();

		add(ico = new oc.Picture("oc/wh40k/images/TYKrieger.jpg"));

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Sensenklauen", 0));
		ogE.addElement(new OptionsGruppeEintrag("Zangenkrallen", 0));
		ogE.addElement(new OptionsGruppeEintrag("Hornschwerterpaare", 0));
		ogE.addElement(new OptionsGruppeEintrag("Peitschen & Hornschwerter", "Tentakelpeitschen und Hornschwerter", 0));
		add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
		o1.setSelected(0, true);

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Neuralfresser", 0));
		ogE.addElement(new OptionsGruppeEintrag("Zangenkrallen", 0));
		ogE.addElement(new OptionsGruppeEintrag("Stachelfäuste", 0));
		ogE.addElement(new OptionsGruppeEintrag("Säurespucker", 0));
		ogE.addElement(new OptionsGruppeEintrag("Sensenklauen", 0));
		add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
		o2.setSelected(0, true);

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("1 x Stachelwürger", 10));
		ogE.addElement(new OptionsGruppeEintrag("1 x Biozidkanone", 15));
		add(o3 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

		seperator();

		add(oe1 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Adrenalindrüsen", 5));
		add(oe2 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Toxinkammern", 5));

		seperator();

		pod = new RuestkammerStarter(ID, randAbstand, cnt, "TYLandungsspore", "Landungsspore");
		pod.initKammer();
		add(pod);

		complete();
	}

	@Override
	public void refreshen() {
		if(!o1.isSelected())
			o1.setSelected(0, true);
		if(!o2.isSelected())
			o2.setSelected(0, true);

		o1.setPreis(1, squad.getModelle() * 5);
		o1.setPreis(2, squad.getModelle() * 10);
		o1.setPreis(3, squad.getModelle() * 15);
		
		int heavy = o3.isSelected() ? 1 : 0;
		o2.setPreis(3, (squad.getModelle() - heavy) * 5);

		oe1.setPreis(squad.getModelle() * 5);
		oe2.setPreis(squad.getModelle() * 5);
	}

}
