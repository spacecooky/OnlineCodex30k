package oc.wh40k.units.ig;

import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.OptionsZaehlerGruppe;

public class IGCrassusArmouredAssaultTransport extends Eintrag {

  OptionsZaehlerGruppe o5;
  OptionsZaehlerGruppe o5x;
  OptionsZaehlerGruppe o4;
  OptionsZaehlerGruppe o4x;

  public IGCrassusArmouredAssaultTransport() {
    name = "Crassus Armoured Assault Transport";
    grundkosten = 250;


    add(ico = new oc.Picture("oc/wh40k/images/Shadowsword.gif"));
    


    add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Radarsuchkopfrakete", 10));
    add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Bulldozerschaufel", 10));

    seperator(5);

    ogE.addElement(new OptionsGruppeEintrag("zusätzliches Maschinengewehr", 10));
    ogE.addElement(new OptionsGruppeEintrag("zusätzlicher Sturmbolter", 10));
    add(new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));

    seperator();

    ogE.addElement(new OptionsGruppeEintrag("Heavy Bolter", "Front sponson with Heavy Bolter", 0));
    add(o4x = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 2));
    ogE.addElement(new OptionsGruppeEintrag("Heavy Flamer", "Front sponson with Heavy Flamer", 0));
    ogE.addElement(new OptionsGruppeEintrag("Autocannon", "Front sponson with Autocannon", 5));
    ogE.addElement(new OptionsGruppeEintrag("Lascannon", "Front sponson with Lascannon", 10));
    add(o4 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 2));

    seperator();

    ogE.addElement(new OptionsGruppeEintrag("Heavy Bolter", "Side sponson with Heavy Bolter", 0));
    add(o5x = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 2));
    ogE.addElement(new OptionsGruppeEintrag("Heavy Flamer", "Side sponson with Heavy Flamer", 0));
    ogE.addElement(new OptionsGruppeEintrag("Autocannon", "Side sponson with Autocannon", 5));
    ogE.addElement(new OptionsGruppeEintrag("Lascannon", "Side sponson with Lascannon", 10));
    ogE.addElement(new OptionsGruppeEintrag("Armour plates", 0));
    add(o5 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 2));

    complete();

  }

  public void refreshen() {
      o5.setMaxAnzahl(o5.isSelected("Armour plates") ? 1 : 2);
      o5x.setMaxAnzahl(o5.isSelected("Armour plates") ? 1 : 2);

      o5.setButtonMaxAnzahl("Armour plates", 1);
      
      o4x.setAnzahl(0, o4x.getMaxAnzahl() - o4.getAnzahl());
      o5x.setAnzahl(0, o5x.getMaxAnzahl() - o5.getAnzahl());

  }
}
