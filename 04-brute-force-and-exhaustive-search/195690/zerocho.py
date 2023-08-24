def minimize_pain(n):
    item_effects = {
        'bandage': 1,
        'medicine': 7,
        'painkiller': 14
    }

    item_order = ['painkiller', 'medicine', 'bandage']  # 아이템 선택 우선순위

    item_count = 0

    while n > 0:
        for item in item_order:
            if n >= item_effects[item]:
                use_count = n // item_effects[item]
                n -= use_count * item_effects[item]
                item_count += use_count
                break

    return item_count


pain_level = int(input())
min_items_needed = minimize_pain(pain_level)
print(min_items_needed)
