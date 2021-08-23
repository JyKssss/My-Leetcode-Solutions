package Contest;

import java.util.HashMap;
import java.util.HashSet;

public class lc5809 {
    public int countPalindromicSubsequence(String s) {
        int[] dp=new int[s.length()];
        HashSet<String>set=new HashSet<>();
        HashMap<Character,Integer>map=new HashMap<>();
        for (int i = 2; i <s.length() ; i++) {
            char cur=s.charAt(i);
            dp[i]=dp[i-1];
            //寻找Start节点
            int start=map.getOrDefault(cur, 0)-1;
            start= Math.max(start, 0);
            for (int j = start; j <i-1 ; j++) {
                if (s.charAt(j)==cur){
                    for (int k = j+1; k <i ; k++) {
                        String pair=String.valueOf(cur)+String.valueOf(s.charAt(k))+String.valueOf(cur);
                        if (!set.contains(pair)){
                            set.add(pair);
                            dp[i]++;
                        }
                    }
                    break;
                }
            }
            map.put(cur, i);
        }
        return dp[s.length()-1];
    }

    public int countPalindromicSubsequence2(String s) {
        HashMap<Character,int[]>map=new HashMap<>();
        HashSet<Character>visitedSet=new HashSet<>();
        HashSet<String>strSet=new HashSet<>();
        int cnt=0;
        for (int i = 0; i < s.length(); i++) {
            char cur=s.charAt(i);
            if (map.containsKey(cur)){
                int[] startEnd=map.get(cur);
                startEnd[1]=i;
            }
            else {
                map.put(cur, new int[]{i,-1});
            }
        }

        for (int i = 0; i < s.length(); i++) {
            char cur=s.charAt(i);
            if (!visitedSet.contains(cur)){
                int start=map.get(cur)[0],end=map.get(cur)[1];
                if (end!=-1){
                    for (int j = start+1; j <end ; j++) {
                        String pair=String.valueOf(cur)+String.valueOf(s.charAt(j))+String.valueOf(cur);
                        if (!strSet.contains(pair)){
                            cnt++;
                            strSet.add(pair);
                        }
                    }
                }
                visitedSet.add(cur);
            }
        }
        return cnt;

    }
}


/*
"tnapzbjeznakaxowyeqefiwxpoxswedvabnyyuihjenxmpzxyyokldoijgvekjxxvxsvcnrinonkofilfyllcacophzuusnbyhpxoqtnbhezbvwtnejsxcyxsbffqaxfryagvvzzvjvbdgrwkowqfwthrkkhxvmpqkslrfqcxmeiygryknhocdvwyomdzmcfvetugpldpbytefioyiyxjfqkdhbefrlwbgnodzbrknqeyjdcgjovtdfqobqxyqhqltrpizlxdnjdqezzwjaudlsofkvjykktlkjiksffefwrqxotkqfdcqhvuqbfoejnelskrhtoekufkmwdyiyptwrucawbwixfdfvjxpvmshcoxdknqeomzrxzrdltdjjearvypexzyoxzxbdhkdzurzisycpuaxkewehnxmxbghllbttlcodzqtajxjarsiuwukiysomgxxcrincvucbjeuuwaauwqeqwlwucdsftccyaugbcinmfzpehrwbeaefdozssbeizeqppnhlvtnrzgtbbitqvctsatcpxjrrbgvltmmtizepbjmmywzmxldtkadizqkaurepeckdiakhyofmslyezbybimhgyukaieqrlddhsuwjzblkfigwixzuopifdiqzfpgvmmanctqcmpxygluuhdwbgqivmdhizpnvqypdttfuhukvagdaqtcmxdqoptchhsledydwojisoqqkivahoowbsdbbdnygtziktmonqkevvlcxggqobvfbfgdwnitratmrsobpfpaspjxefnxthonefpiigdhapqnkebutwfotvrxvjbqowgnifeimsslktxmpuryccaabahalsycjqztjhqhaddlyzxdqyuwyecslxshaobrfkjalmeaxrywssfgrzervzbowosusthcjvojxsoiqkpjztdrxrkycgdyqlorxixzdiqtwozuvkvwzonogoytrumivjynvfjktcqlvxeauncdbygkvocvaadeubgykjkshkflpmpbmaiaswjocrqjzmabmxmocssxltgzaiuwfkadwuylnmskyqbpsmxhehicevfmauuxubeirvflsxcdtyoljsansqcmhokbgyjkxxwdeorlzjgbuekogddsabucrpawdxwuemmckqouddnwbnzogtvjfgblwuarykpwtdpuxqtephulabcxdqjkmuxhniiynkwrsypromcminqgghhnixxojhvnkglrtxduhrjoiupeswqfuveqmgmhondpgzvzaeyylzphofblzpmkdejubwhoguyrfxoaiqhlfqogovdoifuvfqyctzhmcvfleefcgippkfccsltjpjohwmunimqvpjspsjufikghgpmaygslukijmsxcgfjzmewqpvvzjtcxcsbcylhwhxfingcbruyyeoyxgvfsbcvedmtsdygawtnanbdbedwvohgecgqtbjalurkoknzyjpsttnknmufpjhpkjjifalqdwutqhgaflmmmwmkbyxxhbmkqlpjnmywmjfxezdshafnakulqhbndlmtausobzyjrlsgdxcjkbhyfokvdogxabwgmbmzymclxqzwygoxvirnrvpruugvlhyhzzbpugvovfymdcojtkicemybixlvemaydgwmypkwhpeeijccuaomczvqzaedzjrvjobxibpzpveekzcpqnvhbpgqscprawrsvjnhskugziigdecpdcldburpsldqyopyfmaeebawgemrksidizkixosauykmzdwgpyxskuqsujamvnfirtnnxzpplyulsootbikqumwyxpgiplhqbfxggnbylklyuhvoknyuqhpbzfrhdgzoiofrcqyadtgrrkxfecyioobzwwaguuyzcldtumdrhcujkeysxqztzeinrfztjiktcnvfequtbzfrxmukqfblajzyqkvzwcvpoddmzsiqaviivhwbhzdgjdikbnbihaziswypwjcgixefughvoowvoprhohxtbxkrgbbypcmmjogpouceqowqafseywnzanhuueobfrfnikpxhgwdkqmzkegdeqdrdbzttrdfyoqsvacfdsuwikrrlfqfjwwrmylgleuvtnfchhetmtblhffwvzhmlduqjzoqdgjgcwnikbycxggyywoyxqzayirooafchtgupqryojjqxiwjtnmlorcxgwfkzbrzldtfcgxkzqxxcypcgptygmhetsymzuxcnfoasytoetzorfvgbevfhblqassjttvlrvejeaevkcebklsesswnxpzpilvprflevlipyuvfhumcpudbtnwokqsvbewugbwobocncgovbmvduscdlkqctlrziaaaravaitvpceycuojutpszirunhheodrohntdvhqbjblapaggiijnnkogdhfirjvujbsqbfkwoquaqqyyebgbdkvdonaqgweymynjtnbgebsqheorskegksjsnfiucwvhzkjttwbkfrirhyxacjkhhovnxutjonezizmvbrarbwgxftjvgiskfdccpnsuopfpqffkifwwsyxpntikmnkowxaevzacucdpygjmsghzdskaqfjudbibdnuhofkmvptkesypnblikcyswhnktvquimklubsdduabfznfkwcwaelitcefxjvneomwloxqzvhzdhouzuigwxtnkfqpdcjravnzpbhoyslgukpoykqvwrvqttrtwcndupqodohuxouwyxcvufuuloybqaoeqlkxqefozfpirxqxnroavhaikrzxolauuktodrcooiqyfovcvwtuiiydvukdpuwhxwvetarnpxkzdzkfcfpvvayjbqcqbtbkeqfplkdsfhamlhesldkwrpiocwsvxyzoybuayrgzflcdyjyfxkmymfzxrcejfkvzimozjelxohpsepbwhbvlhblrvknyxtmnxbvqwxpvcfnzeotmtpglvwowweriaftyaupslrzlskygkudujaocveqiezrraizyrkdbqyboiklpbpuglphoaexaiapsrozprnhdwitnqqhlolvxsljexkkftraqhuzbqzmnjdqxnseviomtunraqrujswrwtksilarexetwgenlkdvpegyrtwuvfyoxockgrxetsyeykzeyfsiprcwycsjaqnyyoaimrvffqdrnpycmmbnspgavfhiliicsjxvmvnglwbygwsqcyuajlqydpmbtdmhdvnwjedivvlbiunullhemiitroipzuispedyxzvlidwwbujfqgydwwvuwbaiafqoechwnjpzmmwzflqlyqdajntejfynueovtebfdvahcjacggesmaemncluxmitjqmjwyiqnurlxoskoeldmbrfusyrzyyieooptwyturpqgogeqsgpxfoikmqtwfvhyoggvupselvwleebbgxmnmcmxipoxgdvtcukuwoewgopyxnnojftsjneqkbvtztfhhxqvwocbvefsxwadpuspjahmqtfpfakmfpczdbddfdrslmrbptcckdedslsrytyfqsaolinrlwvucthchurqdiarzdhdvpsjzsvbtrufrpdsmaczdhljijhyfayxuazykjegmbpbszlwafdhqxigwvrqfshgdqxkmxqjxiblrzjlegmcvglcotunbaxuocktcenonvrldaszsmfblgmfcbwjnhhuesaoennjllgadafrwfkvxlglkvcpnvsmazkliiptubprdgarpoybstwqhagzbubpnvhvvykpzqqfprvjohkjcfhbmggeietzrppxzlasxelzramnvoecberauqcyyyugrtopxuldczztnqzynvwzyxhdtlwjnyolnlaevgbmmcvvjcpcqcexrpuplxdskyrwrbbjsguuljbxqehxroijcypwrqeqxyshpjggpalibaocdzjtvkodnoufnnnpwdgmztlolqbhfvptsjtpvzwscfsxizbgocivaexhhddciafhaokbtmxtudgntqoyswmocchnzuvqxqyoqnugzkqlyjixcigircpsrbrmjsjsjbcrbvnuufiksdngjbmbpqhdnpehjjwutolmbugauiljtixouiifuuadwjuwuweksbkipfbsreeehzulwsmktpkcescjznynnkbtzamnkszdwepyluaulzkgevbsxbnftmfipktbozqjgnidotnwjtybrlhjqidfwcyesluptzrqvclutghqtmawojebmsrbwpkgbiqapufsndqfwwawwutnskmhxviegxyglvfnjbpfsoarturgpdlnrwtuolpnexrbzipdmhldjacsptjggxvqpegoczzrmkvyoznnbpyedvafxarklcxnqroumkachjuhxgoyqqcnbmktwqfiwpvuafuavkejvyyplbarlzrkcaqxhccvzfhvocpxpumnautlohdnoqepunoonqdnrqubauljvoxapdydwtjwqpveazoayxjdbliiyllsrdhpucrvohppyledyiplvwxgtgdvjhmviudvdvjvsatbkyxkylfdwmeeoisuacnyversgdkkyyujmbjosycozpvxcvcecwtfvubofabliaygszcnuoihvdompowkdgytktyundmuvcxsbgbjopfemhzuslnwgwdnkhoblfozzxynozifxuqwkdbillhbjqjjkfevpoitcmssrpxcccuyczaihyrbseasjgvysceacdliuowbekvxccfsewzrrgqqahymtsvmoyspjaftbakyqzuarpajywlnstboqxyzipxyjtgjodjbbzopqklxvbosmbsgmgrsyrohpzjfamjweifqvbfjgxecnebeysduiwbtabxkrjatoxngdxckfdyhryyltzozlwwcpplebygrwuxdjncmmapalciesoelycusejxunxsrolunfjocpitrmscobbzignvpfojynpxuhyibcnetebopnqvfreghmhfdtnckyjpfadqaafbysfdsmwdwgsbudcibgfrviugvljxcndbaepkwrtmjpwetndugvtvbkeoufdmnjojvvxltxjsycnkjhhtgrllzrpefkaqjldedwdhdfkdvirsgdrwqynmzyqtydgivcprgfigdzzyzejbnfgfvvgcvwnkjsjmsxogilpxuguxqyjgjmwkypnzbfhcijnxoyyxhcitpiyokvewglzdjszgkyhzyqpgxyvhiisbofufyranrdyvxddjocyhejzhxlxugvqrbmqeqvanuwvfllpkiemcxqbtsvvybyjqrbadwediirydahzrdxtnqczxffqjeuespeswuiszjxrfgequlsenpajmsxvufflnzmcbzbepudnewjcmecqyzfzrqecwrvlsgwumitdfzfrdyxnqthzizwosrrweykjvqzfrxgxumubqnhrmcgmiwyuqiarfkkburfvmjbsubiouyrjlsboxilaycspfiojemadgleaqqcschyotlyknqkonfemmcpudqraysznmojvyyrxsiccuieyruqedbdbvumjzolxmsakokirlkopyxcvkjrawakjsmatzoqzlcqqdsffspsejeekfhzwpxqooikxklhigxythgbxpkyptgswhlfwwgnrrodbikpmyzrnunwhgcaxodrcmbixnfqujmpwdgbhlhydpovdtjdctlwwnpepqvzoluxpygjhgikcfojxheverdwflekraglpnsukvvauzqsxohtyducrmxbgzhvbfuvyevphketsttfdzqgddkzfwffgmbrrllyawdmptixbhjbyegpuveahxubolyuvuxaleeuhwbvsxgwmucxqrigcupwybjonxerqiwbepuprkthgntymqlubedcbnzbszoutbxzbwwmsuypjpqgjptxccexytgoeawdcerrgwjyxtaofzhlxannnpihaewpjnjpwermqxkqfypigexmuejdkxjcvdroydhbyytfditsklmsekvsrybjignqocfcrtbhnwsevcwcvujhrwsnwonzhatciobihdvaueyxmqmvnuyqhwtudldhepsldbehbhpnuctyxowwcwlvkpzhrcescobwkareaaytofkwaqiegngsyoekveutblnlvtyweoxwnxrwfvktnqwzxttelgozczeruffpconzjetsbmstyaymkqkqjpaxncrguqmlklnczkwqohrerzvdkjykjewocifqpxeiprqalhdwagmtkpzblqmoophrgjqokbnuuwcmhlyikpvcjungiuequwievzedlkhpbvengnuawoerbmrogpmvtcjzgdyuxbfrstkpwpqazjhotelovzlonmsadmkqactlxdgxhzdpbmryoyvjhbdudxplmileyepifqrlammkorippicvgfavzhsfevxbtkryybsmyqqmeunogjiroephrjsikzijcbibwbiclhmtqjdlnttculjhuofhxfimnfdfcurgqxzlamnexbummavlibelhirysmuncoclmhwmtljevpbifkpoxqlzipourcnompngysesoknxehhyuhtxrsplowvxisjnytvbdlptpxvvvhoqxlcaiphzyvuufmwnkncsqfntwccgzmohxoxaurwvovvlpjdwypfucvinttmttrfratdgpaynwzhqidsbbnvuwsbiwhsfbisumjkxcrnpofgqsqozzvljylgqwvgmejwchkrbdngmlwoktjaxhnjgbskaczmyqfnvxkgzzarodzadkkyncqrlnppuyoobmgtxwqraenthplhiycsvtnxdmlxazuyzutvvutahfnnbmoltzfgktlvcspqcyfvwzeddgebgrewxpsjmatbbrrvhoejuvqbmqcqdtomptmtzwofecmhdhgxqfkcvbfjlrfmdkseydapugxkdofypampacgiuzalpctalecojbnwrmeavixutuzcevzmaggbzvthuxedqaifptdtysphvumeqfeqjcxmcmvsazdyvjocacocynxcuokthpnkmlwzrdmzxnhlatlrzzcahwdlbkttytyfpsdfifonhybefzkhesabetmydaxaffbanghskgcanouzdduaywjtqvdmytpnustqkothzyywomggbxvznrgdcvyccwirojgntzizegwajigkaiypgpswldbbdwsvsocnxqnptzdxdnnbgidfxqfiyfzahecuyoioryquziarxcameblaconlastezdtyljdrgnjmltfvxxtiszhedlzwhvaqiamtqftmdgokmkeyttdlykznwskjskddzyqlzwlwhqmvrpqjazcnnmhdgwvhhktjdcculgtjjoezrhhvtcsmfonmargfrunwusnhunzkwawvzeewirhuewdkitnaymcswkzfbsclvqxbchyfxmdcrtpmqkucqkytyrqtbncqvqvijadflfnsaxorvnadmtsmycarcqzexrwpzgmdfiflkwxauorsjjwnaqrhudwzevkazptowgraurjlrgwxjtwditvxvkayfjzyqtxewssqwphwnfaxtpvvifdjbmjuokhsgrywgocivwhmgzmvplyigitxcoblmudptmcjewqtvmfjdultzukmdjlafvmjutmztmsfmhfaelvvnileboiuknzxenhbkgaqjfmbvfiszkkdpfnsvpkragxnkresuugjanvumptyiwlgaeriltnwmiglcsavndefkvlfbeydctvvqmpzceuewjhvkoaeclpfweaekyooczgrgvbowlwtxucyluxryhfevexjfcvehlzxafottibwqpzisfpdszmocxdkjbzoldlkkiewohzpgtpasnohatztwabascyvpeuxuywgagoafxjffaejbvxuizcxfiisxfknoosffufewkelanjtnqdvutcwbutkxppydgmfmijexjpwqoxizcdkbfmgkywhirnxgcxsxlltaoetngwhesbrwjihsdpcgvnlxldmzjtwdcosguiyuptzhomlqvffgepojjqbisryhwinutnvoziluduankdpehfuwtcpeeejtnjuyktzloetwqcyughhopuprkvldkgvivzjfbvqagbtcfjfqdhmcpjabzydmakkytvbzwkfnyaofehcvrwrfwfkayqhcldfcjxhxfemxnmkxawfghqbhlbiinlzvmqehewhfhucmfiuunkgozewujfvdobrentgqzainixmyekhipaupfnglhwqthlynhlkjolqwwgkmrkgovzbrwcjnpablyevanisqvkhgkwaxfgglnfkqraksxdyeekwxqupulqlftrvbmfkhv"
 */