package oc.wh40k.units.gk;

import oc.AnzahlPanel;
import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.OptionsZaehlerGruppe;

public class GKPaladinTrupp extends Eintrag {

	AnzahlPanel squad;
	OptionsZaehlerGruppe o1;
	OptionsZaehlerGruppe o1def;
	OptionsUpgradeGruppe o2;
	OptionsZaehlerGruppe o3;
	OptionsZaehlerGruppe o3def;
	OptionsZaehlerGruppe o4;
    OptionsEinzelUpgrade apo;
    OptionsEinzelUpgrade banner;

	public GKPaladinTrupp() {
		name = "Paladin-Trupp\n";
		grundkosten = 0;
		überschriftSetzen = true;

		squad = new AnzahlPanel(ID, randAbstand, cnt, "Paladin", "Paladine", 1, 10, 55);
		add(squad);

		add(ico = new oc.Picture("oc/wh40k/images/GKPaladinTrupp.jpg"));
		

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Psischwert", "Nemesis-Psischwert", 0));
		add(o1def = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 0));
		ogE.addElement(new OptionsGruppeEintrag("Psihellebarde", "Nemesis-Psihellebarde", 0));
		ogE.addElement(new OptionsGruppeEintrag("Dämonenhammer", "Nemesis-Dämonenhammer", 0));
		ogE.addElement(new OptionsGruppeEintrag("Falchions", "Paar Nemesis-Falchions", 5));
		ogE.addElement(new OptionsGruppeEintrag("Meisterhaftes Psischwert", "Meisterhaftes Nemesis-Psischwert", 5));
		ogE.addElement(new OptionsGruppeEintrag("Meisterhafte Psihellebarde", "Meisterhafte Nemesis-Psihellebarde", 5));
		ogE.addElement(new OptionsGruppeEintrag("Meisterhafter Däm.hammer", "Meisterhafter Nemesis-Dämonenhammer", 5));
		ogE.addElement(new OptionsGruppeEintrag("Meisterhafte Falchions", "Paar Meisterhafte Nemesis-Falchions", 10));
		add(o1 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 0));

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Wehrstab", "1 x Nemesis-Wehrstab", 20));
		ogE.addElement(new OptionsGruppeEintrag("Meisterhafter Wehrstab", "1 x Meisterhafter Nemesis-Wehrstab", 25));
        add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Sturmbolter", 0));
		add(o3def = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 0));
		ogE.addElement(new OptionsGruppeEintrag("Meisterhafter StuBo", "Meisterhafter Sturmbolter", 5));
		add(o3 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 0));

		ogE.addElement(new OptionsGruppeEintrag("Erlöser-Flamer", "Erlöser-Flammenwerfer", 5));
		ogE.addElement(new OptionsGruppeEintrag("Psipulser", 10));
		ogE.addElement(new OptionsGruppeEintrag("Psibolter", 20));
		ogE.addElement(new OptionsGruppeEintrag("Meisterhafter Erlöser-F.", "Meisterhafter Erlöser-Flammenwerfer", 10));
		ogE.addElement(new OptionsGruppeEintrag("Meisterhafter Psipulser", 15));
		ogE.addElement(new OptionsGruppeEintrag("Meisterhafter Psibbolter", 25));
		add(o4 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 0));

        seperator();

		add(apo = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", "Apothecarius", "Upgrade zum Apothecarius", 75));
        add(banner = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", "Bruderschaftsbanner", 25));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", "Psi-Aktive Munition", 20));

		complete();
	}

	@Override
	public void refreshen() {
		int subtractor = (o2.isSelected()? 1 : 0) + (banner.isSelected() ? 1 : 0);
		o1.setMaxAnzahl(squad.getModelle() - subtractor); // heavy weapon
		o1def.setMaxAnzahl(squad.getModelle() - o1.getAnzahl() - subtractor);
		o1def.setAnzahl(0, squad.getModelle() - o1.getAnzahl() - subtractor);

		subtractor = o4.getAnzahl() + (apo.isSelected() ? 1 : 0);
		o3.setMaxAnzahl(squad.getModelle() - subtractor); // heavy weapon
		o3def.setMaxAnzahl(squad.getModelle() - o3.getAnzahl() - subtractor);
		o3def.setAnzahl(0, squad.getModelle() - o3.getAnzahl() - subtractor);

        o4.setMaxAnzahl((int) Math.floor(squad.getModelle() / 5) * 2);
	}

}
