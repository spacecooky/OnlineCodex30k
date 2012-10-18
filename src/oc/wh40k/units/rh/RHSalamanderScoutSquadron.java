package oc.wh40k.units.rh;

import oc.AnzahlPanel;
import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsEinzelZaehler;
import oc.OptionsGruppeEintrag;
import oc.OptionsZaehlerGruppe;

public class RHSalamanderScoutSquadron extends Eintrag {

	AnzahlPanel squad;
	
	OptionsZaehlerGruppe wpn;
	OptionsEinzelZaehler hk;
	OptionsEinzelZaehler db;
	OptionsEinzelZaehler ea;
	OptionsEinzelUpgrade cn;

	public RHSalamanderScoutSquadron() {
		name = "Salamander Scout Squadron";
		grundkosten = 0;

		squad = new AnzahlPanel(ID, randAbstand, cnt, "Salamander Scout", "Salamander Scouts", 1, 3, 55);
		squad.setGrundkosten(0);
		add(squad);

		add(ico = new oc.Picture("oc/wh40k/images/RHScoutSentinelSquadron.jpg"));

		seperator();

		ogE.add(new OptionsGruppeEintrag("Storm bolter", 10));
		ogE.add(new OptionsGruppeEintrag("Heavy stubber", 10));
		add(wpn = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 3));
		add(hk = new OptionsEinzelZaehler(ID, randAbstand, cnt, "option", "Hunter-killer missile", 1,10));
		add(db = new OptionsEinzelZaehler(ID, randAbstand, cnt, "option", "Dozer Blade", 1,10));
		add(ea = new OptionsEinzelZaehler(ID, randAbstand, cnt, "option", "Extra armour", 1,15));
		seperator();

		add(cn = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", "Camo netting", 0));

		complete();
	}

	@Override
	public void refreshen() {
		wpn.setMaxAnzahl(squad.getModelle());
		hk.setMaxAnzahl(squad.getModelle());
		db.setMaxAnzahl(squad.getModelle());
		ea.setMaxAnzahl(squad.getModelle());
		
		cn.setPreis(squad.getModelle() * 20);

	}

}
