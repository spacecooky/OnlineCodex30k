package oc.wh40k.units.ty;

import oc.AnzahlPanel;
import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.OptionsZaehlerGruppe;
import oc.RuestkammerStarter;

public class TYTermaganten extends Eintrag {

	AnzahlPanel squad;
	OptionsZaehlerGruppe o1;
	OptionsUpgradeGruppe o2;
	OptionsEinzelUpgrade oe1;
	OptionsEinzelUpgrade oe2;
	RuestkammerStarter pod;

	public TYTermaganten() {
		name = "Termaganten";
		grundkosten = 0;

		BuildaHQ.addToInformationVector("TYTermaganten", 1);

		int termaganten = BuildaHQ.getCountFromInformationVector("TYTermaganten");
		int tervigons = BuildaHQ.getCountFromInformationVector("TYTervigon");
		if(termaganten > 0 && tervigons == 0) {
			BuildaHQ.getChooserGruppe(3).addSpezialAuswahl("Tervigon");
		}

		squad = new AnzahlPanel(ID, randAbstand, cnt, "Termaganten", 10, 30, 5);
		add(squad);

		seperator();

		add(ico = new oc.Picture("oc/wh40k/images/TYGanten.jpg"));

		ogE.addElement(new OptionsGruppeEintrag("Würgespinne", 10));
		add(o1 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 0));

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Bohrkäferschleudern", 0));
		ogE.addElement(new OptionsGruppeEintrag("Stachelfäuste", 0));
		ogE.addElement(new OptionsGruppeEintrag("Stachelharpunen", 0));
		ogE.addElement(new OptionsGruppeEintrag("Neuralfresser", 0));
		add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
		o2.setSelected(0, true);

		seperator();

		add(oe1 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Adrenalindrüsen", 1));
		add(oe2 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Toxinkammern", 1));

		seperator();

		pod = new RuestkammerStarter(ID, randAbstand, cnt, "TYLandungsspore", "Landungsspore");
		pod.initKammer();
		add(pod);

		complete();
	}

	@Override
	public void refreshen() {
		o1.setMaxAnzahl(squad.getModelle() / 10);

		int webs = o1.getAnzahl();

		o2.setPreis(0, 0);
		o2.setPreis(1, (squad.getModelle() - webs) * 1);
		o2.setPreis(2, (squad.getModelle() - webs) * 1);
		o2.setPreis(3, (squad.getModelle() - webs) * 5);

		if(!o2.isSelected()) o2.setSelected(0, true);

		oe1.setPreis(squad.getModelle() * 1);
		oe2.setPreis(squad.getModelle() * 1);

		pod.setAktiv(squad.getModelle() <= 20);
	}

	@Override
	public void deleteYourself() {
		super.deleteYourself();
		BuildaHQ.addToInformationVector("TYTermaganten", -1);
		int termaganten = BuildaHQ.getCountFromInformationVector("TYTermaganten");
		int tervigons = BuildaHQ.getCountFromInformationVector("TYTervigon");
		if(termaganten == 0 && tervigons > 0) {
			BuildaHQ.getChooserGruppe(3).removeSpezialAuswahl("Tervigon");
		}
	}

}
