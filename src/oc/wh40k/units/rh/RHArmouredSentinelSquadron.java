package oc.wh40k.units.rh;

import oc.AnzahlPanel;
import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsEinzelZaehler;
import oc.OptionsGruppeEintrag;
import oc.OptionsZaehlerGruppe;

public class RHArmouredSentinelSquadron extends Eintrag {

	AnzahlPanel squad;
	OptionsZaehlerGruppe o1;
	OptionsZaehlerGruppe o1x;
	OptionsEinzelZaehler oe1;
	OptionsEinzelZaehler oe2;
	OptionsEinzelUpgrade oe3;
	OptionsEinzelUpgrade oe4;


	public RHArmouredSentinelSquadron() {
		name = "Armoured Sentinel Squadron";
		grundkosten = 0;

		squad = new AnzahlPanel(ID, randAbstand, cnt, "Armoured Sentinel", "Armoured Sentinels", 1, 3, 55);
		squad.setGrundkosten(0);
		add(squad);

		add(ico = new oc.Picture("oc/wh40k/images/RHArmouredSentinelSquadron.jpg"));

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Multi-laser", 0));
		ogE.addElement(new OptionsGruppeEintrag("Heavy Flamer", 5));
		ogE.addElement(new OptionsGruppeEintrag("Autocannon", 5));
		ogE.addElement(new OptionsGruppeEintrag("Missile launcher", 10));
		ogE.addElement(new OptionsGruppeEintrag("Lascannon", 15));
		ogE.addElement(new OptionsGruppeEintrag("Plasma cannon", 20));
		ogE.addElement(new OptionsGruppeEintrag("Multiple rocket pod", 15));
		add(o1 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 3));

		seperator();

		add(oe1 = new OptionsEinzelZaehler(ID, randAbstand, cnt, "option", "Searchlight", 3, 1));
		add(oe2 = new OptionsEinzelZaehler(ID, randAbstand, cnt, "option", "Hunter-killer missile", 3, 10));

		seperator();

		add(oe3 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", "Smoke launchers", 0));
		add(oe4 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", "Camo netting", 0));

		complete();
	}

	@Override
	public void refreshen() {
		o1.setMaxAnzahl(squad.getModelle());
		o1.setLegal(o1.getAnzahl()==o1.getMaxAnzahl());

		oe1.setMaxAnzahl(squad.getModelle());
		oe2.setMaxAnzahl(squad.getModelle());
		oe3.setPreis(squad.getModelle() * 5);
		oe4.setPreis(squad.getModelle() * 10);
	}

}
